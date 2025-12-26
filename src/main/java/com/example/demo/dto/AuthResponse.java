package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponse {
    private String token;   // 🔥 TEST EXPECTS THIS NAME
    private Long userId;
    private String email;
    private String role;
}
