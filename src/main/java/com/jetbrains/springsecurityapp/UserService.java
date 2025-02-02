package com.jetbrains.springsecurityapp;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<AppUser> getAllUsers(){
        return userRepository.findAll();
    }


    public ResponseEntity<String> createUser(@RequestBody AppUser User)throws Exception{

        Optional<AppUser> UserOptional = userRepository.findByUsername(User.getUsername());
        if(UserOptional.isPresent()){
            throw new BadRequestException("User already exists.");
        }
        userRepository.save(User);

        return ResponseEntity.ok("User created successfully!");
    }

}
