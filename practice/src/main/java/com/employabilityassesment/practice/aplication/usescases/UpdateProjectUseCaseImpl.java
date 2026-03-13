package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.BusinessException;
import com.employabilityassesment.practice.domain.exception.ProjectNotFound;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.ports.in.UpdateProjectUseCase;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateProjectUseCaseImpl implements UpdateProjectUseCase {
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;

    @Override
    public void updateProject(UUID projectId, String projectName) {
        Project project = projectRepositoryPort.findById(projectId)
                .orElseThrow(() -> new ProjectNotFound("The project has not been found!"));

        if (projectName == null){
            throw new BusinessException("The project must have a name!");
        }

        if (!project.getOwnerId().equals(currentUserPort.getCurrentUser())){
            throw new RuntimeException("Forbidden");
        }

        project.setProjectName(projectName);
        projectRepositoryPort.saveProject(project);
    }
}
