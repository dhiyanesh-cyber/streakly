package com.example.streakly.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;

    @NotNull
    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    @Email
    private String email;
    private String password;
    private int loginStreakCount = 0;
    private int completionStreakCount = 0;

    @CreationTimestamp
    private LocalDateTime createdAt;


    @PrePersist
    public void generateId(){
        if (this.userId == null){
            this.userId = UUID.randomUUID().toString();
        }
    }
}
