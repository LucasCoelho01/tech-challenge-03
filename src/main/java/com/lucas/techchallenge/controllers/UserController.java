package com.lucas.techchallenge.controllers;

import com.lucas.techchallenge.model.User;
import com.lucas.techchallenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity<User> getAllCategories() {
        User user = new User(2L, "Ana", "ana@email.com");

        return new ResponseEntity<>(userRepository.insert(user) , HttpStatus.OK);
    }
}
