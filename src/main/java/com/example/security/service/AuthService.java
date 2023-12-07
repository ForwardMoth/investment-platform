package com.example.security.service;

import com.example.domain.dto.client.CreateClientDto;
import com.example.domain.dto.security.JwtResponse;
import com.example.domain.dto.security.LoginUserDto;
import com.example.domain.entity.Client;
import com.example.domain.mapper.ClientMapper;
import com.example.exception.AuthException;
import com.example.security.jwt.JwtCore;
import com.example.service.ClientService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtCore jwtCore;
    private final ClientMapper clientMapper;
    private final ClientService clientService;
    private final AuthenticationManager authenticationManager;

    public JwtResponse register(CreateClientDto createClientDto) {
        if (!Objects.equals(createClientDto.getPassword(), createClientDto.getRepeatPassword())) {
            throw AuthException.CODE.INVALID_REPEAT_PASSWORD.get();
        }
        Client client = clientMapper.toEntity(clientService.save(createClientDto));
        String accessToken = jwtCore.generateAccessToken(client);
        String refreshToken = jwtCore.generateRefreshToken(client);
        return new JwtResponse(accessToken, refreshToken);
    }

    public JwtResponse login(LoginUserDto loginUserDto){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUserDto.getEmail(), loginUserDto.getPassword()));
        } catch (BadCredentialsException e) {
            throw AuthException.CODE.NO_SUCH_USERNAME_OR_PWD.get();
        }
        final Client client = clientService
                .findOne(loginUserDto.getEmail())
                .orElseThrow(AuthException.CODE.NO_SUCH_USERNAME_OR_PWD::get);
        final String accessToken = jwtCore.generateAccessToken(client);
        final String refreshToken = jwtCore.generateRefreshToken(client);
        return new JwtResponse(accessToken, refreshToken);
    }

    public JwtResponse getAccessToken(String refreshToken) {
        return generateAccessTokenOrRefresh(refreshToken, "getAccessToken");
    }

    public JwtResponse refresh(String refreshToken) {
        return generateAccessTokenOrRefresh(refreshToken, "refresh");
    }

    private JwtResponse generateAccessTokenOrRefresh(String refreshToken, String action) {
        if (jwtCore.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtCore.extractRefreshClaims(refreshToken);
            final String username = claims.getSubject();
            final Integer id = (Integer) claims.get("client_id");
            clientService.findById(Long.valueOf(id));
            Client clientForJwt = new Client();
            clientForJwt.setEmail(username);
            clientForJwt.setId(Long.valueOf(id));
            final String accessToken = jwtCore.generateAccessToken(clientForJwt);
            if (action.equals("refresh")) {
                final String newRefreshToken = jwtCore.generateRefreshToken(clientForJwt);
                return new JwtResponse(accessToken, newRefreshToken);
            } else {
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }
}
