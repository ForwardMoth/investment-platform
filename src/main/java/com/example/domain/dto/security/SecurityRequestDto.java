package com.example.domain.dto.security;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "request with security params")
public class SecurityRequestDto {
    @Schema(description = "Security name", example = "Gazprom")
    private String name;

    @Schema(description = "Security ticker", example = "GAZP")
    private String ticker;

    @Schema(description = "Security type", example = "share")
    private String typeOfInvestment;

    @Schema(description = "Security price today", example = "161,50")
    private long price;
}