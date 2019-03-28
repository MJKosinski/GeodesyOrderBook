package com.geohor.controller;

import com.geohor.controller.validationGroup.FullValidation;
import com.geohor.controller.validationGroup.PartValidation;
import com.geohor.entity.User;
import com.geohor.myenum.UserType;
import com.geohor.repository.UserRepository;
import com.geohor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @ModelAttribute("userTypes")
    public UserType[] userTypes(){
        return UserType.values();
    }


    @GetMapping("/{type}/form")
    public String userForm(Model model, @PathVariable String type){
        model.addAttribute("user", new User());
        return "user/"+type+"/form";
    }

    @GetMapping("/form")
    public String userForm(Model model){
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("{type}/form")
    public String userForm(@Valid User user, BindingResult err, @Validated({FullValidation.class}) User userFull, BindingResult errFull, HttpServletRequest req, @PathVariable String type, HttpSession session){

        if(user.getId()==null && errFull.hasErrors()){
            //new user must pass password
            return "user/"+type+"/form";
        }
        //if edit user don't must pass password
        if(user.getId() != null && err.hasErrors()){
            return "user/"+type+"/form";
        }
        User loggedUser = (User) session.getAttribute("logUser");
        if(loggedUser.getId()==user.getId()){
            session.setAttribute("logUser",user);
        }
        userService.save(user);
        return "redirect:"+req.getContextPath()+"/user/"+type+"/list";
    }

    @GetMapping("{type}/form/{id}")
    public String userForm(Model model, @PathVariable Long id, @PathVariable String type){
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        return "user/"+type+"/form";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "user/login";

    }

    @PostMapping("/login")
    public String login(@Validated({PartValidation.class}) User user, BindingResult err, Model model, HttpSession session, HttpServletRequest req) throws Exception {
        if (err.hasErrors()) {
            return "user/login";
        }
        try {
            User logedInUser = userService.checkLogin(user.getEmail(), user.getPassword());
            session.setAttribute("logUser", logedInUser);
            return "redirect:" + req.getContextPath() + "/";

        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "user/login";
        }
    }

    @GetMapping("{type}/list")
    public String userList(Model model, HttpSession session, @PathVariable String type) {
        User user = (User) session.getAttribute("logUser");
        UserType fulltype = user.getType();
        model.addAttribute("users", userService.findAll(fulltype));
        return "user/"+type+"/list";
    }


    @GetMapping("{type}/list/del/{id}")
    public String delUser(HttpSession session, @PathVariable Long id, @PathVariable String type, HttpServletRequest req, Model model){
        User user = (User) session.getAttribute("logUser");
        UserType fulltype = user.getType();

        try {
            userService.delUser(fulltype, id);
        }
        catch (JpaSystemException e) {
            String errMsg = "Nie można usunąć użytkownika "+userRepository.findOne(id).getName()+"! Jest on przypisany do istniejących zleceń.";
            model.addAttribute("errorMsg", errMsg);
            return "forward:"+req.getContextPath()+"/user/"+type+"/list";
        }
        return "redirect:"+req.getContextPath()+"/user/"+type+"/list"; /// ???
    }

}
