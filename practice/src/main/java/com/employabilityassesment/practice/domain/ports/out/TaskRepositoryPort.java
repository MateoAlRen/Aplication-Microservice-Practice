package com.employabilityassesment.practice.domain.ports.out;

import com.employabilityassesment.practice.domain.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepositoryPort {
    Optional<Task> findById(UUID taskId);
    Task saveTask(Task task);
    List<Task> findByProjectId(UUID projectId);
}
