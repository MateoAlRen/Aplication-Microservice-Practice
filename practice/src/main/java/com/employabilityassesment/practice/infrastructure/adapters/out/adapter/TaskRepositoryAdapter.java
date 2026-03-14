package com.employabilityassesment.practice.infrastructure.adapters.out.adapter;

import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.domain.ports.out.TaskRepositoryPort;
import com.employabilityassesment.practice.infrastructure.adapters.out.TaskJpaRepository;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.TaskEntity;
import com.employabilityassesment.practice.infrastructure.adapters.out.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskJpaRepository taskJpaRepository;
    private final TaskMapper taskMapper;

    @Override
    public Optional<Task> findById(UUID taskId) {
        return taskJpaRepository
                .findById(taskId)
                .map(taskMapper::toModel);
    }

    @Override
    public Task saveTask(Task task) {
        TaskEntity taskEntity = taskMapper.toEntity(task);
        TaskEntity saved = taskJpaRepository.save(taskEntity);
        return taskMapper.toModel(saved);
    }

    @Override
    public List<Task> findByProjectId(UUID projectId) {
        return taskJpaRepository
                .findByProject_ProjectIdAndIsDeletedFalse(projectId)
                .stream()
                .map(taskMapper::toModel)
                .toList();
    }
}
