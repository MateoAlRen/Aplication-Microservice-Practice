package com.employabilityassesment.practice.infrastructure.adapters.in.controller;

import com.employabilityassesment.practice.domain.ports.in.*;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.request.CreateTaskRequest;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.request.UpdateTaskRequest;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.response.TaskResponse;
import com.employabilityassesment.practice.infrastructure.adapters.in.webmapper.TaskWebMapper;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    private final CompleteTaskUseCase completeTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final FindAllTaskByProjectUseCase findAllTaskByProjectUseCase;
    private final TaskWebMapper taskWebMapper;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> tasksResponse(UUID projectId){
        return ResponseEntity.ok(taskWebMapper.toResponseList(findAllTaskByProjectUseCase.findAllTasksByProject(projectId)));
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody CreateTaskRequest createTaskRequest){
        createTaskUseCase.createTask(createTaskRequest.projectId(), createTaskRequest.taskTitle());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{taskId}/complete")
    public ResponseEntity<Void> completeTask(@PathVariable UUID taskId){
        completeTaskUseCase.completeTask(taskId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId){
        deleteTaskUseCase.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateTask(@RequestBody UpdateTaskRequest updateTaskRequest){
        updateTaskUseCase.updateTask(updateTaskRequest.taskId(), updateTaskRequest.taskTitle());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
