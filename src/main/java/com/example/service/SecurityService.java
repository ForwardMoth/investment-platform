package com.example.service;

import com.example.domain.dto.security.SecurityRequestDto;
import com.example.domain.dto.security.SecurityResponseDto;

import java.util.List;

public interface SecurityService {
    SecurityResponseDto save(SecurityRequestDto securityRequestDto);

    SecurityResponseDto findOne(Long id);

    List<SecurityResponseDto> findAll();

    SecurityResponseDto update(Long id, SecurityRequestDto securityRequestDto);

    void delete(Long id);
}
