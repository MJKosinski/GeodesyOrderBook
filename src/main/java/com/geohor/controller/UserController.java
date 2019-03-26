package com.geohor.controller;

import com.geohor.entity.User;
import com.geohor.myenum.UserType;
import com.geohor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @ModelAttribute("userTypes")
    public UserType[] userTypes(){
        return UserType.values();
    }


    @GetMapping("/form")
    public String userForm(Model model){
        model.addAttribute("user", new User());

        return "user/form";
    }

    @PostMapping("/form")
    public String userForm(@Validated User user, BindingResult err, HttpServletRequest req){

        if(err.hasErrors()){
            return "user/form";
        }

        userRepository.save(user);
        return "redirect:"+req.getContextPath()+"/user/list";
    }

    @GetMapping("/form/{id}")
    public String userForm(Model model, @PathVariable Long id){
        User user = userRepository.findOne(id);
        model.addAttribute(user);
        return "/user/form";
    }


}
