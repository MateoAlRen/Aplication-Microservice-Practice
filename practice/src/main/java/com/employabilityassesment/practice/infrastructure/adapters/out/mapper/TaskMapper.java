package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface TaskMapper {
    TaskEntity toEntity (Task taskModel);
    Task toModel (TaskEntity taskEntity);
}
