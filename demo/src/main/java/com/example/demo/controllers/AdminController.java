package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repositories.AdminRepository;



@RestController
@RequestMapping("/admin")

public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/dashboard")
    public ModelAndView adminIndex() {         
        return new ModelAndView("admin/dashboard.html");
    }
}