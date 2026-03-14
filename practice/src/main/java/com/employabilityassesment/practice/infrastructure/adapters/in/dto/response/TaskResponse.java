package com.employabilityassesment.practice.infrastructure.adapters.in.dto.response;

import java.util.UUID;

public record TaskResponse(
        UUID taskId,
        UUID projectId,
        String taskName,
        boolean isCompleted,
        boolean isDeleted
) {
}
