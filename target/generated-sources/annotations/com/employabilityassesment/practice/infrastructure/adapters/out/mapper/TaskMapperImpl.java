package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.TaskEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-12T03:39:16-0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Amazon.com Inc.)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskEntity toEntity(Task taskModel) {
        if ( taskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setTaskId( taskModel.getTaskId() );
        taskEntity.setTaskTitle( taskModel.getTaskTitle() );
        taskEntity.setCompleted( taskModel.isCompleted() );
        taskEntity.setDeleted( taskModel.isDeleted() );

        return taskEntity;
    }

    @Override
    public Task toModel(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        Task task = new Task();

        task.setTaskId( taskEntity.getTaskId() );
        task.setTaskTitle( taskEntity.getTaskTitle() );
        task.setDeleted( taskEntity.isDeleted() );
        task.setCompleted( taskEntity.isCompleted() );

        return task;
    }
}
