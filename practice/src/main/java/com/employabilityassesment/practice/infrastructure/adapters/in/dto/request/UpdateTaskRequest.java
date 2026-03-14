package com.employabilityassesment.practice.infrastructure.adapters.in.dto.request;

import java.util.UUID;

public record UpdateTaskRequest(
        UUID taskId,
        String taskTitle
) {
}
