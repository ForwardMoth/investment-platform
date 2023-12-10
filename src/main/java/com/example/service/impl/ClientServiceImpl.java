package com.example.service.impl;

import com.example.domain.dto.client.ClientResponseDto;
import com.example.domain.dto.client.CreateClientDto;
import com.example.domain.entity.Client;
import com.example.domain.mapper.ClientMapper;
import com.example.exception.AuthException;
import com.example.exception.ClientException;
import com.example.repository.ClientRepository;
import com.example.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final PasswordEncoder encoder;

    @Override
    @Transactional
    public ClientResponseDto save(CreateClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        client.setPassword(encoder.encode(client.getPassword()));
        client.setEmail(client.getEmail());
        if (clientRepository.existsByEmail(client.getEmail())) {
            throw AuthException.CODE.EMAIL_IN_USE.get();
        }
        clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponseDto findById(Long id) {
        return clientMapper.toDto(clientRepository
                .findById(id)
                .orElseThrow(ClientException.CODE.NO_SUCH_CLIENT::get));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findOne(String username) {
        return clientRepository.findByEmail(username);
    }

}
