package com.example.controller.api;


import com.example.domain.dto.client.CreateClientDto;
import com.example.domain.dto.security.JwtResponse;
import com.example.domain.dto.security.LoginUserDto;
import com.example.domain.dto.security.RefreshJwtRequest;
import com.example.exception.message.ClientErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Auth API", description = "API for auth in the platform")
public interface AuthApi {
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success enter in the account",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = JwtResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad client's credentials",
                    content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ClientErrorMessage.class)
                    )
            }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User with such username is not found",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ClientErrorMessage.class)
                            )
                    }
            )
    })
    @Operation(summary = "Return jwt token")
    ResponseEntity<JwtResponse> login(
            @Parameter(description = "Client email and password")
            @RequestBody LoginUserDto loginUserDto
    );

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success account registration",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = JwtResponse.class)
                            )
                    }
            )
    })
    @Operation(summary = "Return jwt token")
    ResponseEntity<JwtResponse> register(@RequestBody CreateClientDto createClientDto);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success getting access token",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = JwtResponse.class)
                            )
                    }
            )
    })
    @Operation(summary = "Return accessToken and refreshToken = null")
    ResponseEntity<JwtResponse> getAccessToken(@RequestBody RefreshJwtRequest refreshJwtRequest);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success refresh",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = JwtResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User with such username is not found",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ClientErrorMessage.class)
                            )
                    }
            )
    })
    @Operation(summary = "Return updated access and refresh token")
    ResponseEntity<JwtResponse> refresh(@RequestBody RefreshJwtRequest refreshJwtRequest);
}