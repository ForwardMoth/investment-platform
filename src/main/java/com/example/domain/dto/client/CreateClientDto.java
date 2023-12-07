package com.example.domain.dto.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "creation client profile")
public class CreateClientDto {
    @Schema(description = "client's email", example = "jackson@gmail.com")
    private String email;

    @Schema(description = "client's password", example = "1234")
    private String password;

    @Schema(description = "repeating client's password", example = "1234")
    private String repeatPassword;
}

