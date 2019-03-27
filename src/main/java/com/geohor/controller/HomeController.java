package com.geohor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";

    }

}
