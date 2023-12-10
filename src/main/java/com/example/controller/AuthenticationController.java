package com.example.controller;

import com.example.controller.api.AuthApi;
import com.example.domain.dto.client.CreateClientDto;
import com.example.domain.dto.auth.JwtResponse;
import com.example.domain.dto.auth.LoginUserDto;
import com.example.domain.dto.auth.RefreshJwtRequest;
import com.example.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthApi {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody CreateClientDto createClientDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.register(createClientDto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginUserDto loginUserDto) {
        return ResponseEntity.status(HttpStatus.OK)
                        .body(authService.login(loginUserDto));
    }

    @PostMapping("/access-token")
    public ResponseEntity<JwtResponse> getAccessToken(@RequestBody RefreshJwtRequest refreshJwtRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.getAccessToken(refreshJwtRequest.getRefreshToken()));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refresh(@RequestBody RefreshJwtRequest refreshJwtRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.refresh(refreshJwtRequest.getRefreshToken()));
    }
}
