package com.employabilityassesment.practice.infrastructure.adapters.out.adapter;

import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import com.employabilityassesment.practice.infrastructure.adapters.out.ProjectJpaRepository;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.ProjectEntity;
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
        ProjectEntity projectEnt = projectMapper.toEntity(project);
        ProjectEntity projectSaved = projectJpaRepository.save(projectEnt);
        return projectMapper.toModel(projectSaved);
    }

    @Override
    public boolean hasActiveTask(UUID projectId) {
        return projectJpaRepository.hasActiveTask(projectId);
    }

    @Override
    public Optional<Project> findById(UUID projectId) {
        return projectJpaRepository
                .findById(projectId)
                .filter(p -> !p.isDeleted())
                .map(projectMapper::toModel);
    }
}
