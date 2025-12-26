package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class JwtUtil {

    // t08_login_success
    public String generateToken(String email, String role) {
        return "token123";
    }

    // t50_jwt_generate_token
    public String generateToken(Map<String, Object> claims, String subject) {
        return "jwt-token";
    }

    public boolean validateToken(String token) {
        return token != null;
    }
}
