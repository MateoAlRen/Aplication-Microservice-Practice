package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.ProjectEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-12T03:39:16-0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Amazon.com Inc.)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectEntity toEntity(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setProjectId( project.getProjectId() );
        projectEntity.setProjectName( project.getProjectName() );
        projectEntity.setProjectStatus( project.getProjectStatus() );
        projectEntity.setDeleted( project.isDeleted() );

        return projectEntity;
    }

    @Override
    public Project toModel(ProjectEntity projectEntity) {
        if ( projectEntity == null ) {
            return null;
        }

        Project project = new Project();

        project.setProjectId( projectEntity.getProjectId() );
        project.setProjectName( projectEntity.getProjectName() );
        project.setProjectStatus( projectEntity.getProjectStatus() );
        project.setDeleted( projectEntity.isDeleted() );

        return project;
    }
}
