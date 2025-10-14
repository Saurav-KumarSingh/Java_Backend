package com.saurav.springboot.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(registry->{
           registry.requestMatchers("/home").permitAll();
           registry.requestMatchers("/admin/**").hasRole("ADMIN");
           registry.requestMatchers("/user").hasRole("USER");
           registry.anyRequest().authenticated();
        })
                .formLogin(formLogin->formLogin.permitAll())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails= User.builder()
                .username("Suarav")
                .password("$2a$12$NUgVUiBTfe7oI1oI9TT/q.o2KL1JOtn/WhzVQmf7v8kwG1uHqUgsK")
                .roles("USER").build();

        UserDetails adminuserDetails= User.builder()
                .username("Sks")
                .password("$2a$12$gyy1BUux8q0JkwGANyDW3uoUkdWOwJGjvd2DFnvmM3ltqOCTGHxMe")
                .roles("ADMIN","USER").build();

        return new InMemoryUserDetailsManager(userDetails,adminuserDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
