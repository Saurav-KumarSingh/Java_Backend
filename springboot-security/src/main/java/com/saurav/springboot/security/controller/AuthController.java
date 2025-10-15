package com.saurav.springboot.security.controller;

import com.saurav.springboot.security.dto.LoginRequest;
import com.saurav.springboot.security.dto.SignupRequest;
import com.saurav.springboot.security.dto.UserResponse;
import com.saurav.springboot.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody SignupRequest signupRequest) {
        return authService.registerUser(signupRequest);
    }

    @PostMapping("/login")
    public UserResponse loginUser(@RequestBody LoginRequest loginRequest){
        return  authService.loginUser(loginRequest);
    }
}
