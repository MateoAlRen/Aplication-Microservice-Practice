package com.employabilityassesment.practice.domain.ports.in;

import java.util.UUID;

public interface CreateTaskUseCase {
    void createTask(UUID projectId, String taskName);
}
