package com.example.service;

import com.example.domain.dto.security.SecurityRequestDto;
import com.example.domain.dto.security.SecurityResponseDto;

public interface SecurityService {
    SecurityResponseDto save(SecurityRequestDto securityRequestDto);
}
