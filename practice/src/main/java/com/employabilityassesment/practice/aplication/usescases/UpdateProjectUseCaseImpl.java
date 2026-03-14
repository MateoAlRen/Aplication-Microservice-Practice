package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.BusinessException;
import com.employabilityassesment.practice.domain.exception.ProjectNotFound;
import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.AuditAction;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.ports.in.UpdateProjectUseCase;
import com.employabilityassesment.practice.domain.ports.out.AuditLogPort;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.NotificationPort;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateProjectUseCaseImpl implements UpdateProjectUseCase {
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;
    private final NotificationPort notificationPort;
    private final AuditLogPort auditLogPort;

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
        auditLogPort.register(new Audit(
                null,
                currentUserPort.getCurrentUser(),
                project.getProjectId(),
                AuditAction.UPDATE_PROJECT
        ));
        notificationPort.sendNotification("A user update a project!");
    }
}
