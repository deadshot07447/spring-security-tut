package com.learnsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

    @GetMapping("/home")
    public String home(){

        return "this is home page";
    }


    @GetMapping("/register")
    public String register(){

        return "this is register page";
    }

    public String about(){

        return "this is about page";
    }


}
