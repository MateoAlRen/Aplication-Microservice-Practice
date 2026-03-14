package com.employabilityassesment.practice.domain.ports.in;

import java.util.UUID;

public interface DeleteTaskUseCase {
    void deleteTask (UUID taskId);
}
