package com.geohor.controller;

import com.geohor.entity.User;
import com.geohor.entity.Work;
import com.geohor.myenum.CatalogType;
import com.geohor.myenum.StatusType;
import com.geohor.myenum.UserType;
import com.geohor.myenum.WorkType;
import com.geohor.repository.UserRepository;
import com.geohor.repository.WorkRepository;
import com.geohor.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkService workService;

    @Autowired
    WorkRepository workRepository;

    @ModelAttribute("subcontractors")
    public List<User> getConstractors(){

        return userRepository.findAllByTypeIs(UserType.SUBCONTRACTOR);
    }

    @ModelAttribute("catalogTypes")
    public CatalogType[] catalogTypes() {
        return CatalogType.values();
    }

    @ModelAttribute("workTypes")
    public WorkType[] workTypes() {
        return WorkType.values();
    }

    @ModelAttribute("statusTypes")
    public StatusType[] statusTypes() {
        return StatusType.values();
    }


    @GetMapping("/{type}/form")
    public String workForm(Model model, @PathVariable String type) {
        Work work = new Work();
        model.addAttribute("work", work);

        return "work/"+type+"/form";
    }

    @GetMapping("/{type}/form/{id}")
    public String workForm(Model model, @PathVariable String type, @PathVariable Long id, HttpSession session) {
        User logUser = (User) session.getAttribute("logUser");
        if(logUser.getType() != UserType.SUBCONTRACTOR){
            Work work = workRepository.findOne(id);
            model.addAttribute("work", work);
            return "work/"+type+"/form";
        }

        return "work/"+type+"/list";
    }



    @PostMapping("/{type}/form")
    public String workForm(@Validated Work work, BindingResult err, HttpServletRequest req , @PathVariable String type,
                HttpSession session ) {
        User logUser = (User) session.getAttribute("logUser");

        if (err.hasErrors()) {
            return req.getContextPath()+"/work/"+type+"/form";
        }
         workService.save(work, logUser);

        return "redirect:"+req.getContextPath()+"/work/"+type+"/list";
    }

    @GetMapping("/{type}/list")
    public String showAll(Model model, HttpSession session, @PathVariable String type){
        User logUser = (User) session.getAttribute("logUser");
        model.addAttribute("works",workService.getAll(logUser));

        return "work/"+type+"/list";
    }


}
