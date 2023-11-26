package com.example.controllers;

import com.example.controllers.api.AuthApi;
import com.example.dto.LoginResponse;
import com.example.dto.LoginUserDto;
import com.example.dto.RegisterUserDto;
import com.example.entities.User;
import com.example.services.AuthenticationService;
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
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authenticationService.signup(registerUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto) {
        return ResponseEntity.status(HttpStatus.OK)
                        .body(authenticationService.signip(loginUserDto));
    }
}
