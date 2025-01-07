package com.example.streakly.service;


import com.example.streakly.model.User;
import com.example.streakly.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepo repo;


    public List<User> getAllUser() {
        return repo.findAll();
    }

    public void addUser(User user) {
        repo.save(user);
    }

    public void deleteUser(String userId) {
        repo.deleteById(userId);
    }
}
