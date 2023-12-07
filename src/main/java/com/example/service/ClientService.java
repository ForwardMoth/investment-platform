package com.example.service;

import com.example.domain.dto.client.ClientResponseDto;
import com.example.domain.dto.client.CreateClientDto;
import com.example.domain.entity.Client;

import java.util.Optional;

public interface ClientService {
    ClientResponseDto save(CreateClientDto client);
    ClientResponseDto findById(Long id);

    Optional<Client> findOne(String username);
}
