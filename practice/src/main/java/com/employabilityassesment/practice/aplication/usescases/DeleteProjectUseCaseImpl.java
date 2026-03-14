package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.BusinessException;
import com.employabilityassesment.practice.domain.exception.ProjectNotFound;
import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.AuditAction;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.ports.in.DeleteProjectUseCase;
import com.employabilityassesment.practice.domain.ports.out.AuditLogPort;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.NotificationPort;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteProjectUseCaseImpl implements DeleteProjectUseCase {
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;
    private final NotificationPort notificationPort;
    private final AuditLogPort auditLogPort;

    @Override
    public void deleteProject(UUID projectId) {
        Project project = projectRepositoryPort.findById(projectId)
                .orElseThrow(() -> new ProjectNotFound("Project has not been founded!"));

        if(!project.getOwnerId().equals(currentUserPort.getCurrentUser())){
            throw new BusinessException("Forbidden");
        }

        project.setDeleted(true);
        projectRepositoryPort.saveProject(project);

        auditLogPort.register(new Audit(
                null,
                currentUserPort.getCurrentUser(),
                project.getProjectId(),
                AuditAction.DELETE_PROJECT
        ));

        notificationPort.sendNotification("A project has been deleted!");
    }
}
