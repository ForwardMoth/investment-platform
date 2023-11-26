package com.example.controllers.api;


import com.example.dto.LoginUserDto;
import com.example.entities.User;
import com.example.dto.LoginResponse;
import com.example.dto.RegisterUserDto;
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
                                    schema = @Schema(implementation = LoginResponse.class)
                            )
                    }
            )
    })
    @Operation(summary = "Return jwt token")
    ResponseEntity<LoginResponse> login(
            @Parameter(description = "User email and password")
            @RequestBody LoginUserDto loginUserDto
    );

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success account registration",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)
                            )
                    }
            )
    })
    @Operation(summary = "Return parameters of user (email, password and e t.c.)")
    ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto);
}