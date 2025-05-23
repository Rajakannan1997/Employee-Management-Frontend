package com.example.employee_management_system.controller;// LoginController.java placeholder content


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/employee-list")
    public String employees() {
        return "employee-list";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}
