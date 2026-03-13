package com.employabilityassesment.practice.infrastructure.adapters.in.controller;

import com.employabilityassesment.practice.domain.ports.in.*;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.request.CreateProjectRequest;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.request.UpdateProjectRequest;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.response.ProjectsResponse;
import com.employabilityassesment.practice.infrastructure.adapters.in.webmapper.ProjectWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {
    private final CreateProjectUseCase createProjectUseCase;
    private final ActivateProjectUseCase activateProjectUseCase;
    private final DeleteProjectUseCase deleteProjectUseCase;
    private final UpdateProjectUseCase updateProjectUseCase;
    private final FindAllProjectsUseCase findAllProjectsUseCase;
    private final ProjectWebMapper projectWebMapper;

    @GetMapping
    public ResponseEntity<List<ProjectsResponse>> getAllProjects(){
        return ResponseEntity.ok(projectWebMapper.toResponseList(findAllProjectsUseCase.findAllProjects()));
    }

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody @Valid CreateProjectRequest project){
        createProjectUseCase.createProject(project.projectName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{projectId}/activate")
    public ResponseEntity<Void> activateProject(@PathVariable UUID projectId){
        activateProjectUseCase.activateProject(projectId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject (@PathVariable UUID projectId){
        deleteProjectUseCase.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Void> updateProject(@PathVariable UUID projectId, @RequestBody @Valid UpdateProjectRequest updateRequest){
        updateProjectUseCase.updateProject(projectId, updateRequest.projectName());
        return ResponseEntity.ok().build();
    }


}
