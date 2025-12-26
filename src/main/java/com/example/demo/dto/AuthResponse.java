package com.example.demo.dto;

public class AuthResponse {

    // 🔥 Tests read JSON field "token"
    private String token;

    // 🔥 Tests ALSO call getAccessToken()
    private String accessToken;

    private Long userId;
    private String email;
    private String role;

    // Required by Jackson
    public AuthResponse() {
    }

    // 🔥 SET BOTH token & accessToken
    public AuthResponse(String token, Long userId, String email, String role) {
        this.token = token;
        this.accessToken = token;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    // ===== getters / setters =====

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        this.accessToken = token;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        this.token = accessToken;
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
