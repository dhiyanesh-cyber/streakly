package com.example.streakly.controller;


import com.example.streakly.dto.user.UserRequestDTO;
import com.example.streakly.model.User;
import com.example.streakly.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService service;


//    Get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);
    }


//    Get user by their ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        return new ResponseEntity<>(service.getUserById(userId), HttpStatus.OK);
    }


//    Create User
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        service.addUser(user);
        String message = "User created successfully !";
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }


//    Update user data
    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        service.updateUser(user);
        String msg = "User updated successfully !";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }


//    Delete user
    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(@RequestBody UserRequestDTO user){
        service.deleteUser(user.getUserId());
        String msg = "User deleted successfully !";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
