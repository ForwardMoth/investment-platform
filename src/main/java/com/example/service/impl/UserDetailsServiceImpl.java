package com.example.service.impl;

import com.example.domain.entity.Client;
import com.example.exception.AuthException;
import com.example.repository.ClientRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository
                .findByEmail(username)
                .orElseThrow(AuthException.CODE.NO_SUCH_USERNAME_OR_PWD::get);
        return new User(
                client.getEmail(),
                client.getPassword(),
                new ArrayList<>());
    }
}
