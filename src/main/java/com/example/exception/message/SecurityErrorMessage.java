package com.example.exception.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record SecurityErrorMessage(
        @Schema(description = "Code error", example = "NO_SUCH_SECURITY")
        String code,
        @Schema(description = "Message error", example = "No security with such id")
        String message) {
}
