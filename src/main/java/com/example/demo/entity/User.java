package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String fullname;
    @NotNull
    @Column(unique = true, nullable = false)
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String role;
    @NotNull(message = "Learning style must not be null")
    private String preferredLearningStyle;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public User() {}

    public User(Long id, String fullname, String email, String password,
                String role, String preferredLearningStyle) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.preferredLearningStyle = preferredLearningStyle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPreferredLearningStyle() {
        return preferredLearningStyle;
    }

    public void setPreferredLearningStyle(String preferredLearningStyle) {
        this.preferredLearningStyle = preferredLearningStyle;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
