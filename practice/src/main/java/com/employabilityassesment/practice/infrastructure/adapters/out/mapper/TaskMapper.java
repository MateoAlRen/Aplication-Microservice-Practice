package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.ProjectEntity;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "projectId", target = "project")
    TaskEntity toEntity(Task task);

    @Mapping(source = "project.projectId", target = "projectId")
    Task toModel(TaskEntity entity);

    default ProjectEntity map(UUID projectId) {
        if (projectId == null) return null;

        ProjectEntity project = new ProjectEntity();
        project.setProjectId(projectId);
        return project;
    }
}
