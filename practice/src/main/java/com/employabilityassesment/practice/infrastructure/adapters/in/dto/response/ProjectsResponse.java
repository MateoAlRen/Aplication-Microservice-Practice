package com.employabilityassesment.practice.infrastructure.adapters.in.dto.response;

import com.employabilityassesment.practice.domain.model.ProjectStatus;

import java.util.UUID;

public record ProjectsResponse(
        UUID projectId,
        String projectName,
        ProjectStatus projectStatus,
        boolean isDeleted
        ) {
}
