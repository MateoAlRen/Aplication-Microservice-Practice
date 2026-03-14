package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.BusinessException;
import com.employabilityassesment.practice.domain.exception.InvalidCredentialsException;
import com.employabilityassesment.practice.domain.exception.ProjectNotFound;
import com.employabilityassesment.practice.domain.exception.TaskNotFoundException;
import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.AuditAction;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.domain.ports.in.DeleteTaskUseCase;
import com.employabilityassesment.practice.domain.ports.out.*;
import com.employabilityassesment.practice.infrastructure.adapters.out.adapter.NotificationPortAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;
    private final NotificationPort notificationPort;
    private final AuditLogPort auditLogPort;

    @Override
    public void deleteTask(UUID taskId) {
        Task task = taskRepositoryPort.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task has not been found!"));

        Project project = projectRepositoryPort.findById(task.getProjectId())
                .orElseThrow(() -> new ProjectNotFound("This task doesn't have a project!"));

        if (!project.getOwnerId().equals(currentUserPort.getCurrentUser())){
            throw new InvalidCredentialsException("You're not the owner of this task or project!");
        }
        if (task.isDeleted()){
            throw new BusinessException("The task is already deleted!");
        }

        task.setDeleted(true);
        taskRepositoryPort.saveTask(task);

        auditLogPort.register(new Audit(
                null,
                currentUserPort.getCurrentUser(),
                task.getTaskId(),
                AuditAction.DELETE_TASK
        ));

        notificationPort.sendNotification("A task has been deleted!");
    }
}
