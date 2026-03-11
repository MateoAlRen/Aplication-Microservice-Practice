package com.employabilityassesment.practice.infrastructure.adapters.out.adapter;

import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import com.employabilityassesment.practice.infrastructure.adapters.out.ProjectJpaRepository;
import com.employabilityassesment.practice.infrastructure.adapters.out.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProjectRepositoryAdapter implements ProjectRepositoryPort {
    private final ProjectJpaRepository projectJpaRepository;
    private final ProjectMapper projectMapper;


    @Override
    public Project saveProject(Project project) {
        return null;
    }

    @Override
    public boolean hasActiveTask(UUID projectId) {
        return false;
    }

    @Override
    public Optional<Project> findById(UUID projectId) {
        return Optional.empty();
    }
}
