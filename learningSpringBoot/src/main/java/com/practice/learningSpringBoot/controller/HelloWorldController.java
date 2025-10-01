package com.practice.learningSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {

    //  @RequestMapping(value = "/hello", method = RequestMethod.GET) //shorthand given below
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World API!";
    }
}
