package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.ProjectEntity;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.TaskEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-14T17:13:29-0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Amazon.com Inc.)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskEntity toEntity(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setProject( map( task.getProjectId() ) );
        taskEntity.setTaskId( task.getTaskId() );
        taskEntity.setTaskTitle( task.getTaskTitle() );
        taskEntity.setCompleted( task.isCompleted() );
        taskEntity.setDeleted( task.isDeleted() );

        return taskEntity;
    }

    @Override
    public Task toModel(TaskEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Task task = new Task();

        task.setProjectId( entityProjectProjectId( entity ) );
        task.setTaskId( entity.getTaskId() );
        task.setTaskTitle( entity.getTaskTitle() );
        task.setDeleted( entity.isDeleted() );
        task.setCompleted( entity.isCompleted() );

        return task;
    }

    private UUID entityProjectProjectId(TaskEntity taskEntity) {
        ProjectEntity project = taskEntity.getProject();
        if ( project == null ) {
            return null;
        }
        return project.getProjectId();
    }
}
