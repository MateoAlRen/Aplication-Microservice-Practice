package com.employabilityassesment.practice.domain.ports.in;

import java.util.UUID;

public interface DeleteProjectUseCase {
    void deleteProject (UUID projectId);
}
