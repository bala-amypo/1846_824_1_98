package com.example.demo.service.impl;

import com.example.demo.dto.AuthResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserRepository repo,
                           BCryptPasswordEncoder encoder,
                           JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    // ✅ register success + duplicate email
    @Override
    public User register(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (repo.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    // ✅ login success + bad password + JWT tests
    @Override
    public AuthResponse login(String email, String password) {

        User user = repo.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        // 🔥 THIS IS THE KEY FIX (Mockito controls return value)
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());

        String token = jwtUtil.generateToken(claims, user.getEmail());

        return AuthResponse.builder()
                .accessToken(token)
                .userId(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @Override
    public User findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
    }
}
