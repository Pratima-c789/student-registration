package com.example.student_registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String rootHome() {
        return "home";   // This loads home.html
    }
}
