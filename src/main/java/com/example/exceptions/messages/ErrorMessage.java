package com.example.exceptions.messages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record ErrorMessage(
        @Schema(description = "Code error", example = "BAD_REQUEST")
        String code,
        @Schema(description = "Message error", example = "BAD_REQUEST")
        String message
) {
}