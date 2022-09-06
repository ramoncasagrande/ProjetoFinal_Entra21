package com.entra21.projeto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.projeto.model.Users;
import com.entra21.projeto.repositories.UserRepository;

@RestController
public class UserController {

    private UserRepository userRepository;

    @GetMapping("/api/users")
    public List<Users> list(){
        return userRepository.findAll();

    }
    
}
