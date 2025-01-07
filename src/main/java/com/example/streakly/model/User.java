package com.example.streakly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@Component
@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;

    private String username;
    private String email;
    private String password;
    private int loginStreakCount;
    private int completionStreakCount;

    @CreationTimestamp
    private LocalDateTime createdAt;


    public User(){
    }


    @PrePersist
    public void generateId(){
        if (this.userId == null){
            this.userId = UUID.randomUUID().toString();
        }
    }
}
