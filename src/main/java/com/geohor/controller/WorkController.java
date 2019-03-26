package com.geohor.controller;

import com.geohor.entity.Work;
import com.geohor.myenum.CatalogType;
import com.geohor.myenum.StatusType;
import com.geohor.myenum.WorkType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/work")
public class WorkController {

    @ModelAttribute("catalogTypes")
    public CatalogType[] catalogTypes(){
        return CatalogType.values();
    }

    @ModelAttribute("workTypes")
    public WorkType[] workTypes(){
        return WorkType.values();
    }

    @ModelAttribute("statusTypes")
    public StatusType[] statusTypes(){
        return StatusType.values();
    }



    @GetMapping("/form")
    public String workForm(Model model) {
        Work work = new Work();
        model.addAttribute("work",work);

        return "work/form";
    }

    @PostMapping("/form")
    public String workForm(@Validated Work work, BindingResult err, HttpServletRequest req ) {
        work.setApplicationDate(LocalDateTime.now());
    if(err.hasErrors()){
        return "work/form";
    }

        return "redirect:"+req.getContextPath()+"/";
    }



}
