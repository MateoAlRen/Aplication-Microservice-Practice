package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.model.ProjectStatus;
import com.employabilityassesment.practice.domain.ports.in.ActivateProjectUseCase;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ActivateProjectUseCaseImpl implements ActivateProjectUseCase {
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;

    @Override
    public void activateProject(UUID projectId) {
        Project project = projectRepositoryPort.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project has not been found!"));

        if (!project.getOwnerId().equals(currentUserPort.getCurrentUser())) {
            throw new RuntimeException("Forbidden");
        }

        boolean hasTask = projectRepositoryPort.hasActiveTask(projectId);
        project.setProjectStatus(ProjectStatus.ACTIVE);

        projectRepositoryPort.saveProject(project);
    }
}
