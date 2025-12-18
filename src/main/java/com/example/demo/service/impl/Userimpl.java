package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.Userservice;
import com.example.demo.dto.AuthResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userimpl implements Userservice {

    @Autowired
    private UserRepository urp;

    @Override
    public User register(User user) {
        return urp.save(user);
    }

    @Override
    public User findById(Long id) {
        return urp.findById(id).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return urp.findByEmail(email);
    }

    @Override
    public AuthResponse login(String email, String password) {
        User user = urp.findByEmail(email);

        if (user == null) {
            return new AuthResponse("User not found", false);
        }

        if (!user.getPassword().equals(password)) {
            return new AuthResponse("Invalid password", false);
        }

        return new AuthResponse("Login successful", true);
    }
}
