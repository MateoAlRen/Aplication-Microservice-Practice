package com.employabilityassesment.practice.domain.ports.in;

import java.util.UUID;

public interface CompleteTaskUseCase {
    void completeTask(UUID taskId);
}
