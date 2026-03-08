package com.employabilityassesment.practice.domain.ports.out;

import com.employabilityassesment.practice.domain.model.Project;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepositoryPort {
    Project saveProject(Project project);
    boolean hasActiveTask(UUID projectId);
    Optional<Project> findById(UUID projectId);
}
