package com.employabilityassesment.practice;

import com.employabilityassesment.practice.aplication.usescases.ActivateProjectUseCaseImpl;
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

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ActivateProjectWithoutOwner {

    @Mock
    private CurrentUserPort currentUserPort;

    @Mock
    private NotificationPort notificationPort;

    @Mock
    private AuditLogPort auditLogPort;

    @Mock
    private ProjectRepositoryPort projectRepositoryPort;

    @InjectMocks
    private ActivateProjectUseCaseImpl activateProjectUseCase;

    @Test
    void ActivateProject_ByNonOwner_ShouldFail(){
        UUID ownerId = UUID.randomUUID();
        UUID projectId = UUID.randomUUID();
        Project project = new Project(projectId, ownerId, "projectName");

        Mockito.when(currentUserPort.getCurrentUser())
                .thenReturn(UUID.randomUUID());

        Mockito.when(projectRepositoryPort.findById(Mockito.any(UUID.class)))
                .thenReturn(Optional.of(project));

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,
                () -> activateProjectUseCase.activateProject(projectId));

        Assertions.assertEquals(ProjectStatus.DRAFT, project.getProjectStatus());
        Mockito.verify(projectRepositoryPort,Mockito.never()).saveProject(project);
        Mockito.verify(notificationPort, Mockito.never()).sendNotification(Mockito.anyString());
        Mockito.verify(auditLogPort, Mockito.never()).register(Mockito.any());
    }
}
