package com.example.controller;

import com.example.domain.dto.security.SecurityRequestDto;
import com.example.domain.dto.security.SecurityResponseDto;
import com.example.service.impl.SecurityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public ResponseEntity<SecurityResponseDto> getOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(securityService.findOne(id));
    }

    @GetMapping("")
    public ResponseEntity<List<SecurityResponseDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(securityService.findAll());
    }

    @PatchMapping("{id}")
    public ResponseEntity<SecurityResponseDto> update(@PathVariable Long id,
                                                      @RequestBody SecurityRequestDto securityRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(securityService.update(id, securityRequestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        securityService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
