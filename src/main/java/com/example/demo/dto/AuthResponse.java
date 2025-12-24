package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponse {

    private String accessToken;
    private Long userId;
    private String email;
    private String role;

    // 🔥 REQUIRED by t08_login_success
    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    // 🔥 REQUIRED by service + builder
    public AuthResponse(String accessToken, Long userId, String email, String role) {
        this.accessToken = accessToken;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }
}
