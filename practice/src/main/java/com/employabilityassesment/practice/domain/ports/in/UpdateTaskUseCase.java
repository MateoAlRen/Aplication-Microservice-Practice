package com.employabilityassesment.practice.domain.ports.in;

import java.util.UUID;

public interface UpdateTaskUseCase {
    void updateTask (UUID taskId, String taskName);
}
