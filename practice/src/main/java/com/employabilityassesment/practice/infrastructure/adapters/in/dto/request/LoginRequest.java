package com.employabilityassesment.practice.infrastructure.adapters.in.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank String userEmail,
        @NotBlank String userPassword
) {
}
