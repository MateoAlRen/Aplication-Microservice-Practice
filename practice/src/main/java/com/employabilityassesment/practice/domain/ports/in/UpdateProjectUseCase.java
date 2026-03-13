package com.employabilityassesment.practice.domain.ports.in;

import java.util.UUID;

public interface UpdateProjectUseCase {
    void updateProject (UUID projectId, String projectName);
}
