package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.BusinessException;
import com.employabilityassesment.practice.domain.exception.ProjectNotFound;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.ports.in.DeleteProjectUseCase;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteProjectUseCaseImpl implements DeleteProjectUseCase {
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;

    @Override
    public void deleteProject(UUID projectId) {
        Project project = projectRepositoryPort.findById(projectId)
                .orElseThrow(() -> new ProjectNotFound("Project has not been founded!"));

        if(!project.getOwnerId().equals(currentUserPort.getCurrentUser())){
            throw new BusinessException("Forbidden");
        }

        project.setDeleted(true);
        projectRepositoryPort.saveProject(project);
    }
}
