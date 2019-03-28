package com.geohor.controller;

import com.geohor.entity.User;
import com.geohor.entity.Work;
import com.geohor.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    WorkService workService;

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        User logUser = (User) session.getAttribute("logUser");
        List<Work> last10 = workService.getLast10(logUser);
        model.addAttribute("last10",last10);
        return "home";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("logUser");
        model.addAttribute("user",new User());

        return "user/login";

    }

}
