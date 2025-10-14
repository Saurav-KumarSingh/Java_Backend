package com.saurav.springboot.security.controller;

import com.saurav.springboot.security.dto.SignupRequest;
import com.saurav.springboot.security.dto.UserResponse;
import com.saurav.springboot.security.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public UserResponse createUser(@RequestBody SignupRequest signupRequest) {
        return registrationService.registerUser(signupRequest);
    }
}
