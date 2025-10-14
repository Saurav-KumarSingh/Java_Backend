package com.saurav.springboot.security.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String role;

}
