package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.ports.in.CreateProjectUseCase;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.NotificationPort;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateProjectUseCaseImpl implements CreateProjectUseCase {
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;

    @Override
    public void CreateProject(String projectName) {
        Project project = new Project(
                UUID.randomUUID(),
                currentUserPort.getCurrentUser(),
                projectName
        );
        projectRepositoryPort.saveProject(project);
    }
}
