package com.example.demo.dto;

public class AuthResponse {

    private String accessToken;
    private Long userId;
    private String email;
    private String role;

    // REQUIRED by Jackson
    public AuthResponse() {
    }

    public AuthResponse(String accessToken, Long userId, String email, String role) {
        this.accessToken = accessToken;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    // 🔥 TESTS USE THIS
    public String getAccessToken() {
        return accessToken;
    }

    // 🔥 JACKSON NEEDS THIS
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
