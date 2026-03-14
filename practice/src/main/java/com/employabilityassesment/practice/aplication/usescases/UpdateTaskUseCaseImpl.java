package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.BusinessException;
import com.employabilityassesment.practice.domain.exception.InvalidCredentialsException;
import com.employabilityassesment.practice.domain.exception.ProjectNotFound;
import com.employabilityassesment.practice.domain.exception.TaskNotFoundException;
import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.AuditAction;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.domain.ports.in.UpdateTaskUseCase;
import com.employabilityassesment.practice.domain.ports.out.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;
    private final NotificationPort notificationPort;
    private final AuditLogPort auditLogPort;

    @Override
    public void updateTask(UUID taskId, String taskName) {

        if (taskName == null || taskName.isBlank()){
            throw new BusinessException("The task needs a name!");
        }

        Task task = taskRepositoryPort.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task has not been found!"));

        Project project = projectRepositoryPort.findById(task.getProjectId())
                .orElseThrow(() -> new ProjectNotFound("This task doesn't have a project!"));

        if (!project.getOwnerId().equals(currentUserPort.getCurrentUser())){
            throw new InvalidCredentialsException("You're not the owner of this task or project!");
        }
        if (task.isCompleted()){
            throw new BusinessException("The task is already completed!");
        }
        if (task.isDeleted()){
            throw new BusinessException("The task is not available!");
        }

        task.setTaskTitle(taskName);
        taskRepositoryPort.saveTask(task);
        auditLogPort.register(new Audit(
                null,
                currentUserPort.getCurrentUser(),
                task.getTaskId(),
                AuditAction.UPDATE_TASK
        ));
        notificationPort.sendNotification("A task has been updated!");
    }
}
