package com.saurav.springboot.security.services;

import com.saurav.springboot.security.dto.LoginRequest;
import com.saurav.springboot.security.dto.SignupRequest;
import com.saurav.springboot.security.dto.UserResponse;
import com.saurav.springboot.security.entity.MyUser;
import com.saurav.springboot.security.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse registerUser(SignupRequest userRequest) {

        // Check if username exists
        if (myUserRepository.findByUserName(userRequest.getUserName()).isPresent()) {
            return new UserResponse("Username already exists!", userRequest.getUserName(), userRequest.getRole());
        }

        // Save new user
        MyUser user = new MyUser();
        user.setUserName(userRequest.getUserName());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRole(userRequest.getRole());

        myUserRepository.save(user);

        return new UserResponse("User registered successfully!", user.getUserName(), user.getRole());
    }

    public UserResponse loginUser(LoginRequest userRequest) {
        Optional<MyUser> userOpt = myUserRepository.findByUserName(userRequest.getUserName());

        if (userOpt.isEmpty()) {
            return new UserResponse("User not found!", userRequest.getUserName(), null);
        }

        MyUser user = userOpt.get();

        // Check password (BCrypt)
        if (!passwordEncoder.matches(userRequest.getPassword(), user.getPassword())) {
            return new UserResponse("Invalid password!", userRequest.getUserName(), null);
        }

        // Login successful
        return new UserResponse("Login successful!", user.getUserName(), user.getRole());
    }
}
