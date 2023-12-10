package com.example.domain.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "RefreshToken")
public class RefreshJwtRequest {
    @Schema(description = "refresh token")
    private String refreshToken;
}
