package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.BusinessException;
import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.ports.in.CreateProjectUseCase;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateProjectUseCaseImpl implements CreateProjectUseCase {
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;

    @Override
    public void createProject(String projectName) {

        if (projectName == null){
            throw new BusinessException("The project need a name!");
        }

        if (currentUserPort.getCurrentUser() == null){
            throw new RuntimeException("Forbidden");
        }

        Project project = new Project(
                null,
                currentUserPort.getCurrentUser(),
                projectName
        );
        projectRepositoryPort.saveProject(project);
    }
}
