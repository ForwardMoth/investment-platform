package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-home")
public class HomeController {

    @GetMapping
    public String index() {
        return "Welcome to the home page!";
    }

}
