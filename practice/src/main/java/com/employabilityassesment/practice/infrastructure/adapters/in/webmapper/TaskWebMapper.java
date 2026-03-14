package com.employabilityassesment.practice.infrastructure.adapters.in.webmapper;

import com.employabilityassesment.practice.domain.model.Task;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.response.TaskResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class TaskWebMapper {

    public TaskResponse toResponse (Task task){
        return new TaskResponse(
                task.getTaskId(),
                task.getProjectId(),
                task.getTaskTitle(),
                task.isCompleted(),
                task.isDeleted()
        );
    }

    public List<TaskResponse> toResponseList (List<Task> tasks){
        return tasks
                .stream()
                .map(this::toResponse)
                .toList();
    }
}
