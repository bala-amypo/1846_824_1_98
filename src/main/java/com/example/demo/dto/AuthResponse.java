package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {

    // Main field used by Java tests
    private String accessToken;

    private Long userId;
    private String email;
    private String role;

    public AuthResponse() {
    }

    public AuthResponse(String accessToken, Long userId, String email, String role) {
        this.accessToken = accessToken;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    // ===== REQUIRED BY TESTS =====
    public String getAccessToken() {
        return accessToken;
    }

    // ===== JSON ALIAS EXPECTED BY TESTS =====
    @JsonProperty("token")
    public String getToken() {
        return accessToken;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.accessToken = token;
    }

    // ===== NORMAL SETTERS FOR JACKSON =====
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
