package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponse {

    // 🔥 REQUIRED BY TESTS (DO NOT REMOVE / RENAME)
    private String accessToken;

    private Long userId;
    private String email;
    private String role;
}
