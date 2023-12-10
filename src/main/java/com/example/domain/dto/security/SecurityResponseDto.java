package com.example.domain.dto.security;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "response answer security entity")
public class SecurityResponseDto {
    @Schema(description = "Security's id")
    private Long id;

    @Schema(description = "Security name")
    private String name;

    @Schema(description = "Security ticker")
    private String ticker;

    @Schema(description = "Security type")
    private String typeOfInvestment;

    @Schema(description = "Security price today")
    private long price;
}
