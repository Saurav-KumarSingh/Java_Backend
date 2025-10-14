package com.saurav.springboot.security.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class SignupRequest {
    private String userName;
    private String password;
    private String role;
}

