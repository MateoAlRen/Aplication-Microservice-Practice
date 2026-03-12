package com.employabilityassesment.practice.infrastructure.adapters.in.controller;

import com.employabilityassesment.practice.domain.ports.in.ActivateProjectUseCase;
import com.employabilityassesment.practice.domain.ports.in.CreateProjectUseCase;
import com.employabilityassesment.practice.domain.ports.in.DeleteProjectUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {
    private final CreateProjectUseCase createProjectUseCase;
    private final ActivateProjectUseCase activateProjectUseCase;
    private final DeleteProjectUseCase deleteProjectUseCase;

}
