package com.employabilityassesment.practice.infrastructure.adapters.in.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank String userEmail,
        @NotBlank String userPassword
) {
}
