package com.employabilityassesment.practice.infrastructure.adapters.in.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserRegisterRequest(
        @NotBlank String userName,
        @NotBlank String userEmail,
        @NotBlank String password
) {
}
