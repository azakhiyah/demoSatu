package com.demoSatu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping("/sign-up")
    public String showRegisterPage() {
        return "sign-up"; // Mengembalikan nama template "register.html"
    }
    
}
