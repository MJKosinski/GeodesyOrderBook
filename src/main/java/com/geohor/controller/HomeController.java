package com.geohor.controller;

import com.geohor.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("user");
        model.addAttribute("user",new User());

        return "user/login";

    }

}
