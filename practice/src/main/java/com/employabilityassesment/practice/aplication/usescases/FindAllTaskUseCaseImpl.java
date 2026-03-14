package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.UserNotValidated;
import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.domain.ports.in.FindAllTaskByProjectUseCase;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindAllTaskUseCaseImpl implements FindAllTaskByProjectUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    private final CurrentUserPort currentUserPort;

    @Override
    public List<Task> findAllTasksByProject(UUID projectId) {
        if (currentUserPort.getCurrentUser() == null){
            throw new UserNotValidated("You don't have a session!");
        }

        return taskRepositoryPort.findByProjectId(projectId);
    }


}
