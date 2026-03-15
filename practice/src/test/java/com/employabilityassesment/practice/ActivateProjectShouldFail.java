package com.employabilityassesment.practice;

import com.employabilityassesment.practice.aplication.usescases.ActivateProjectUseCaseImpl;
import com.employabilityassesment.practice.domain.exception.BusinessException;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.model.ProjectStatus;
import com.employabilityassesment.practice.domain.ports.out.AuditLogPort;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.NotificationPort;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ActivateProjectShouldFail {

    @Mock
    private ProjectRepositoryPort projectRepositoryPort;

    @Mock
    private CurrentUserPort currentUserPort;

    @Mock
    private NotificationPort notificationPort;

    @Mock
    private AuditLogPort auditLogPort;

    @InjectMocks
    private ActivateProjectUseCaseImpl activateProjectUseCase;

    @Test
    void ActivateProjectWithoutTask_ShouldFail(){
        UUID projectId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        Project project = new Project(projectId,ownerId,"projectName");

        Mockito.when(projectRepositoryPort.findById(Mockito.any(UUID.class)))
                .thenReturn(Optional.of(project));

        Mockito.when(projectRepositoryPort.hasActiveTask(Mockito.any(UUID.class)))
                .thenReturn(false);

        Mockito.when(currentUserPort.getCurrentUser())
                .thenReturn(ownerId);

        BusinessException exception = Assertions.assertThrows(
                BusinessException.class,
                () -> activateProjectUseCase.activateProject(projectId)
        );

        Assertions.assertEquals(ProjectStatus.DRAFT, project.getProjectStatus());
        Mockito.verify(projectRepositoryPort,Mockito.never()).saveProject(project);
        Mockito.verify(notificationPort, Mockito.never()).sendNotification(Mockito.anyString());
        Mockito.verify(auditLogPort, Mockito.never()).register(Mockito.any());

    }
}
