package com.employabilityassesment.practice.domain.ports.in;

import com.employabilityassesment.practice.domain.model.Project;

public interface CreateProjectUseCase {
    void CreateProject (String projectName);
}
