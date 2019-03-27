package com.geohor.controller;

import com.geohor.controller.validationGroup.PartValidation;
import com.geohor.entity.User;
import com.geohor.myenum.UserType;
import com.geohor.repository.UserRepository;
import com.geohor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @PostMapping("/form")
    public String userForm(@Validated User user, BindingResult err, HttpServletRequest req){

        if(err.hasErrors()){
            return "user/form";
        }

        userRepository.save(user);
        return "redirect:"+req.getContextPath()+"/user/list";
    }

    @GetMapping("{type}/form/{id}")
    public String userForm(Model model, @PathVariable Long id){
        User user = userRepository.findOne(id);
        model.addAttribute(user);
        return "/user/form";
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
            session.setAttribute("user", logedInUser);
            return "redirect:" + req.getContextPath() + "/";

        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "user/login";
        }
    }

    @GetMapping("/geo/form")
    public String geoForm(){
        return "/user/geo/form";
    }


}
