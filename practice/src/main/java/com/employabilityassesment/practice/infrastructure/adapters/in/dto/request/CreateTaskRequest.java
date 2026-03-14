package com.employabilityassesment.practice.infrastructure.adapters.in.dto.request;

import java.util.UUID;

public record CreateTaskRequest(
        UUID projectId,
        String taskTitle
) {
}
