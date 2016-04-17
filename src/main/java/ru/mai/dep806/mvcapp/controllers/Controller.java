package ru.mai.dep806.mvcapp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    private int visitorCount = 0;

    @RequestMapping("/index.html")
    public String index(Model model){
        model.addAttribute("visitorCount", visitorCount++);
        return "/WEB-INF/jsp/index.jsp";
    }
}
