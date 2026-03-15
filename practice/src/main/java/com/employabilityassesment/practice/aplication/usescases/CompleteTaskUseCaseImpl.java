package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.BusinessException;
import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.AuditAction;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.domain.ports.in.CompleteTaskUseCase;
import com.employabilityassesment.practice.domain.ports.out.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompleteTaskUseCaseImpl implements CompleteTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;
    private final NotificationPort notificationPort;
    private final AuditLogPort auditLogPort;

    @Override
    public void completeTask(UUID taskId) {
        Task task = taskRepositoryPort.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task has been not found!"));

        UUID projectId = task.getProjectId();
        Project project =  projectRepositoryPort.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project has been not found!"));

        if (!project.getOwnerId().equals(currentUserPort.getCurrentUser())) {
            throw new RuntimeException("Forbidden");
        }

        if (task.isCompleted()){
            throw new BusinessException("Task is already completed!");
        }

        task.setCompleted(true);
        taskRepositoryPort.saveTask(task);

        auditLogPort.register(
                new Audit(
                        null,
                        currentUserPort.getCurrentUser(),
                        task.getTaskId(),
                        AuditAction.COMPLETE_TASK
                )
        );

        notificationPort.sendNotification("A task has been completed!");
    }
}
