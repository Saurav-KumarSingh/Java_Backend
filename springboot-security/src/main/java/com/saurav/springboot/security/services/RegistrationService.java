package com.saurav.springboot.security.services;

import com.saurav.springboot.security.dto.SignupRequest;
import com.saurav.springboot.security.dto.UserResponse;
import com.saurav.springboot.security.entity.MyUser;
import com.saurav.springboot.security.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

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
}
