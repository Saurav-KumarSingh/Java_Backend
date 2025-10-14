package com.saurav.springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    @GetMapping("/home")
    public String handleWelcome(){
        return "home !";
    }

    @GetMapping("/admin/home")
    public String handleAdminWelcome() {
        return "Admin home !";
    }

    @GetMapping("/user/home")
    public String handleUserWelcome(){
        return "User home !";
    }

}
