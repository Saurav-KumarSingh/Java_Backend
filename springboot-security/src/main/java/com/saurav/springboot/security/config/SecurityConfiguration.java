package com.saurav.springboot.security.config;


import com.saurav.springboot.security.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Autowired
    private MyUserService myUserService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry->{
           registry.requestMatchers("/home","/register/**","/login").permitAll();
           registry.requestMatchers("/admin/**").hasRole("ADMIN");
           registry.requestMatchers("/user/**").hasAnyRole("USER","ADMIN");
           registry.anyRequest().authenticated();
        })
                .formLogin(AbstractHttpConfigurer::disable) // disable default Spring login form
                .httpBasic(AbstractHttpConfigurer::disable) // disable basic auth
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userDetails= User.builder()
//                .username("Suarav")
//                .password("$2a$12$NUgVUiBTfe7oI1oI9TT/q.o2KL1JOtn/WhzVQmf7v8kwG1uHqUgsK")
//                .roles("USER").build();
//
//        UserDetails adminuserDetails= User.builder()
//                .username("Sks")
//                .password("$2a$12$gyy1BUux8q0JkwGANyDW3uoUkdWOwJGjvd2DFnvmM3ltqOCTGHxMe")
//                .roles("ADMIN","USER").build();
//
//        return new InMemoryUserDetailsManager(userDetails,adminuserDetails);
//    }

    @Bean
    public UserDetailsService userDetailsService(){
        return myUserService;

    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
