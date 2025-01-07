package com.example.streakly.controller;


import com.example.streakly.model.User;
import com.example.streakly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return service.getAllUser();
    }


    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user){
        service.deleteUser(user.getUserId());
    }
}
