package com.example.domain.dto.security;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private long expiresIn;
}
