package com.employabilityassesment.practice.domain.ports.in;

import com.employabilityassesment.practice.domain.model.Task;

import java.util.List;
import java.util.UUID;

public interface FindAllTaskByProjectUseCase {
    List<Task> findAllTasksByProject (UUID projectId);
}
