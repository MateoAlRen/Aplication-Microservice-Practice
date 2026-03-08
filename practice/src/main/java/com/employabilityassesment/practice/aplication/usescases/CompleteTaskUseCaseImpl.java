package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.domain.ports.in.CompleteTaskUseCase;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.ProjectRepositoryPort;
import com.employabilityassesment.practice.domain.ports.out.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompleteTaskUseCaseImpl implements CompleteTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    private final ProjectRepositoryPort projectRepositoryPort;
    private final CurrentUserPort currentUserPort;

    @Override
    public void CompleteTask(UUID taskId) {
        Task task = taskRepositoryPort.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task has been not found!"));

        UUID projectId = task.getProjectId();
        Project project =  projectRepositoryPort.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project has been not found!"));

        task.setCompleted(true);
        taskRepositoryPort.saveTask(task);
    }
}
