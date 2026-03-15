package com.employabilityassesment.practice;

import com.employabilityassesment.practice.aplication.usescases.CompleteTaskUseCaseImpl;
import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.domain.ports.out.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class CompleteTaskShouldGenerate {

    @Mock
    private TaskRepositoryPort taskRepositoryPort;

    @Mock
    private ProjectRepositoryPort projectRepositoryPort;

    @Mock
    private CurrentUserPort currentUserPort;

    @Mock
    private NotificationPort notificationPort;

    @Mock
    private AuditLogPort auditLogPort;

    @InjectMocks
    private CompleteTaskUseCaseImpl completeTaskUseCase;

    @Test
    void CompleteTask_ShouldGenerateAuditAndNotification(){
        UUID taskId = UUID.randomUUID();
        UUID projectId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        Task task = new Task(taskId, projectId, "taskName");
        Project project = new Project(projectId, ownerId, "projectName");

        Mockito.when(taskRepositoryPort.findById(Mockito.any(UUID.class)))
                .thenReturn(Optional.of(task));

        Mockito.when(projectRepositoryPort.findById(Mockito.any(UUID.class)))
                .thenReturn(Optional.of(project));

        Mockito.when(currentUserPort.getCurrentUser())
                .thenReturn(ownerId);

        completeTaskUseCase.completeTask(task.getTaskId());

        Assertions.assertTrue(task.isCompleted());
        Mockito.verify(taskRepositoryPort).saveTask(task);
        Mockito.verify(auditLogPort).register(Mockito.any(Audit.class));
        Mockito.verify(notificationPort).sendNotification(Mockito.anyString());
    }
}
