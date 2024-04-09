package com.lucas.techchallenge.external.apis;

import com.lucas.techchallenge.common.dtos.UserDto;
import com.lucas.techchallenge.communication.controllers.UserController;
import com.lucas.techchallenge.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApi {
    @Autowired
    private UserController userController;
    @PostMapping
    ResponseEntity<User> createUser(@RequestBody UserDto userDto) throws Exception {
        return new ResponseEntity<>(userController.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userController.getAllUsers(), HttpStatus.OK);
    }
}
