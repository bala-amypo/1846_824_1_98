package com.example.demo.dto;

public class AuthResponse {

    private String accessToken;
    private Long userId;
    private String email;
    private String role;

    // REQUIRED for Jackson
    public AuthResponse() {
    }

    public AuthResponse(String accessToken, Long userId, String email, String role) {
        this.accessToken = accessToken;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    // ===== GETTERS (USED BY TESTS) =====
    public String getAccessToken() {
        return accessToken;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // ===== SETTERS (REQUIRED BY JACKSON) =====
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
