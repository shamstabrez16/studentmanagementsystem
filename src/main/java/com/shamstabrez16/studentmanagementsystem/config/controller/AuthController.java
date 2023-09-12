package com.shamstabrez16.studentmanagementsystem.config.controller;


import com.shamstabrez16.studentmanagementsystem.dto.UserDto;
import com.shamstabrez16.studentmanagementsystem.model.User;
import com.shamstabrez16.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService service;

    @Autowired
    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String createNewUser(@ModelAttribute UserDto user) {
        User user1 = User.builder()
                .email(user.getEmail())
                .secretkey(user.getSecretkey()).build();
        service.saveUser(user1);
        return "redirect:/students/all";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto user) {
        User user1 = User.builder()
                .email(user.getEmail())
                .secretkey(user.getSecretkey()).build();
       return  service.findByUsernameOrEmail(user1) ? "redirect:/students/all" :  "redirect:/";
    }
}
