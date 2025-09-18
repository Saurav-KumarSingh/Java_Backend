package com.example.componentsscan.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.example.componentsscan.annotation")
public class AppConfig {
}
