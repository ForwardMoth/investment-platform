package com.example.controller;

import com.example.domain.dto.security.SecurityRequestDto;
import com.example.domain.dto.security.SecurityResponseDto;
import com.example.service.impl.SecurityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/security")
@RestController
@RequiredArgsConstructor
public class SecurityController {
    public final SecurityServiceImpl securityService;

    @PostMapping("/new")
    public ResponseEntity<SecurityResponseDto> create(@RequestBody SecurityRequestDto securityRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(securityService.save(securityRequestDto));
    }
}
