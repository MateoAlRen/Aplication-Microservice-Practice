package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.UserNotValidated;
import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.AuditAction;
import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.domain.ports.in.FindAllTaskByProjectUseCase;
import com.employabilityassesment.practice.domain.ports.out.AuditLogPort;
import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.domain.ports.out.NotificationPort;
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
    private final NotificationPort notificationPort;
    private final AuditLogPort auditLogPort;

    @Override
    public List<Task> findAllTasksByProject(UUID projectId) {
        if (currentUserPort.getCurrentUser() == null){
            throw new UserNotValidated("You don't have a session!");
        }

        auditLogPort.register(new Audit(
                null,
                currentUserPort.getCurrentUser(),
                null,
                AuditAction.GET_TASKS
        ));

        notificationPort.sendNotification("All the tasks of a user are called!");
        return taskRepositoryPort.findByProjectId(projectId);
    }


}
