package com.employabilityassesment.practice.infrastructure.adapters.in.webmapper;

import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.response.ProjectsResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectWebMapper {

    public ProjectsResponse toResponse(Project project){
        return new ProjectsResponse(
                project.getProjectId(),
                project.getProjectName(),
                project.getProjectStatus()
        );
    }

    public List<ProjectsResponse> toResponseList(List<Project> projects){
        return projects
                .stream()
                .map(this::toResponse)
                .toList();
    }

}
