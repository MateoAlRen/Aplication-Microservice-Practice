package com.employabilityassesment.practice.infrastructure.adapters.in.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateProjectRequest(
        @NotBlank String projectName
) {
}
