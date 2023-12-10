package com.example.domain.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Email and Password")
public class LoginUserDto {
    @Schema(description = "email", example = "jackson@gmail.com")
    private String email;
    @Schema(description = "password", example = "1234")
    private String password;
}
