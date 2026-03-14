package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.InvalidCredentialsException;
import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.AuditAction;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.ports.in.FindAllProjectsUseCase;
import com.employabilityassesment.practice.domain.ports.out.AuditLogPort;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.NotificationPort;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindAllProjectsUseCaseImpl implements FindAllProjectsUseCase {
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;
    private final NotificationPort notificationPort;
    private final AuditLogPort auditLogPort;

    @Override
    public List<Project> findAllProjects() {
        UUID ownerId = currentUserPort.getCurrentUser();

        if (ownerId == null){
            throw new InvalidCredentialsException("Forbidden");
        }

        auditLogPort.register(new Audit(
                null,
                currentUserPort.getCurrentUser(),
                null,
                AuditAction.GET_PROJECTS
        ));
        notificationPort.sendNotification("All the projects of a user are called!");
        return projectRepositoryPort.findAllProjectsByOwnerId(ownerId);
    }
}
