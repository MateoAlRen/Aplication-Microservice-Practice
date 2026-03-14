package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.AuditAction;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.domain.ports.in.CreateTaskUseCase;
import com.employabilityassesment.practice.domain.ports.out.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;
    private final NotificationPort notificationPort;
    private final AuditLogPort auditLogPort;

    @Override
    public void createTask(UUID projectId, String taskName) {
        Project project = projectRepositoryPort.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project has not been found"));

        if (!project.getOwnerId().equals(currentUserPort.getCurrentUser())){
            throw new RuntimeException("Forbidden");
        }

        Task task = new Task(
                null,
                project.getProjectId(),
                taskName
        );

        taskRepositoryPort.saveTask(task);

        auditLogPort.register(new Audit(
                null,
                currentUserPort.getCurrentUser(),
                null,
                AuditAction.CREATE_TASK
        ));

        notificationPort.sendNotification("A task has been created!");
    }
}
