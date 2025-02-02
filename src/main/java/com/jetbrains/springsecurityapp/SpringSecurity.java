package com.jetbrains.springsecurityapp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class SpringSecurity {

    public final UserService userService;

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


    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody AppUser user) throws Exception {
        return userService.createUser(user);
    }
}
