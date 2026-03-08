package com.employabilityassesment.practice.domain.ports.in;

import java.util.UUID;

public interface CompleteTaskUseCase {
    void CompleteTask(UUID taskId);
}
