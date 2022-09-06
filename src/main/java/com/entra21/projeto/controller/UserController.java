package com.entra21.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entra21.projeto.model.Users;
import com.entra21.projeto.repositories.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Users> list(){
        return userRepository.findAll();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<Users>> setUser(@PathVariable String email){
        Optional<Users> user = userRepository.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Users>> setUserId(@PathVariable Long id){
        Optional<Users> user = userRepository.findById(id);
        return ResponseEntity.ok(user);
    }
    
}
