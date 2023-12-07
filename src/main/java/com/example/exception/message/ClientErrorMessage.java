package com.example.exception.message;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record ClientErrorMessage(
        @Schema(description = "Code error", example = "NO_SUCH_USER")
        String code,
        @Schema(description = "Message error", example = "No such user")
        String message) {
}