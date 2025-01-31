package com.jetbrains.springsecurityapp;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloWorld {

    @GetMapping("/")
    public String homepage(){
        return "Welcome to Spring Security App";
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userEndpoint(){
        return "Hello User!";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminEndpoint(){
        return "Hello Admin!";
    }
}
