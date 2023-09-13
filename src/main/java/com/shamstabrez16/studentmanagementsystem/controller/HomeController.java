package com.shamstabrez16.studentmanagementsystem.controller;


import com.shamstabrez16.studentmanagementsystem.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    public String getHome(Model model){
        return "index";
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        return "register";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        return "login";
    }
}
