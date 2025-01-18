package com.example.streakly.service;


import com.example.streakly.model.User;
import com.example.streakly.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
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
        LocalDateTime localDateTime = LocalDateTime.now(); // Get local dateTime
        user.setCreatedAt(localDateTime); // Setting it for current user
        repo.save(user);
    }

    public void deleteUser(String userId) {
        repo.deleteById(userId);
    }

    public void updateUser(User user) {
        repo.save(user);
    }

    public User getUserById(String userId) {
        return repo.findById(userId).orElse(new User());
    }
}
