package com.employabilityassesment.practice.domain.ports.in;

import com.employabilityassesment.practice.domain.model.Project;

import java.util.List;
import java.util.UUID;

public interface FindAllProjectsUseCase {
    List<Project> findAllProjects();
}
