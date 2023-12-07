package com.example.domain.mapper;

import com.example.domain.dto.client.ClientResponseDto;
import com.example.domain.dto.client.CreateClientDto;
import com.example.domain.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends EntityMapper<ClientResponseDto, Client> {
    Client toEntity(CreateClientDto dto);

    ClientResponseDto toDto(Client entity);
}
