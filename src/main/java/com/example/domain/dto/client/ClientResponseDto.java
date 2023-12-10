package com.example.domain.dto.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "response answer client entity")
public class ClientResponseDto {
    @Schema(description = "Client's id")
    private Long id;

    @Schema(description = "Client's email")
    private String email;
}
