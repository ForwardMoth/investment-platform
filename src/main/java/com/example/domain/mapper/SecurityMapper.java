package com.example.domain.mapper;

import com.example.domain.dto.security.SecurityRequestDto;
import com.example.domain.dto.security.SecurityResponseDto;
import com.example.domain.entity.Security;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SecurityMapper extends EntityMapper<SecurityResponseDto, Security> {
    Security toEntity(SecurityRequestDto dto);
    SecurityResponseDto toDto(Security entity);
}
