package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.ProjectEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ProjectMapper {
    ProjectEntity toEntity (Project project);
    Project toModel (ProjectEntity projectEntity);
}
