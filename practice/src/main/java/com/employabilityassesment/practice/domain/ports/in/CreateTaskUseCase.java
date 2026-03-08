package com.employabilityassesment.practice.domain.ports.in;

import java.util.UUID;

public interface CreateTaskUseCase {
    void CreateTask(UUID projectId, String taskName);
}
