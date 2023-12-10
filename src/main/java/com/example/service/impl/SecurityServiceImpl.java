package com.example.service.impl;

import com.example.domain.dto.security.SecurityRequestDto;
import com.example.domain.dto.security.SecurityResponseDto;
import com.example.domain.entity.Security;
import com.example.domain.mapper.SecurityMapper;
import com.example.exception.SecurityException;
import com.example.repository.SecurityRepository;
import com.example.service.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class SecurityServiceImpl implements SecurityService {
    private final SecurityMapper securityMapper;
    private final SecurityRepository securityRepository;

    @Override
    @Transactional
    public SecurityResponseDto save(SecurityRequestDto securityRequestDto) {
        Security security = securityMapper.toEntity(securityRequestDto);
        if(securityRepository.existsByTicker(security.getTicker())) {
            throw SecurityException.CODE.TICKER_IN_USE.get();
        }
        securityRepository.save(security);
        return securityMapper.toDto(security);
    }
}
