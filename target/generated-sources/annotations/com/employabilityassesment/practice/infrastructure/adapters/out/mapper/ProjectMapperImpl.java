package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.ProjectEntity;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.UserEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-13T14:43:10-0500",
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

        projectEntity.setOwnerId( map( project.getOwnerId() ) );
        projectEntity.setProjectId( project.getProjectId() );
        projectEntity.setProjectName( project.getProjectName() );
        projectEntity.setProjectStatus( project.getProjectStatus() );
        projectEntity.setDeleted( project.isDeleted() );

        return projectEntity;
    }

    @Override
    public Project toModel(ProjectEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Project project = new Project();

        project.setOwnerId( entityOwnerIdUserId( entity ) );
        project.setProjectId( entity.getProjectId() );
        project.setProjectName( entity.getProjectName() );
        project.setProjectStatus( entity.getProjectStatus() );
        project.setDeleted( entity.isDeleted() );

        return project;
    }

    private UUID entityOwnerIdUserId(ProjectEntity projectEntity) {
        UserEntity ownerId = projectEntity.getOwnerId();
        if ( ownerId == null ) {
            return null;
        }
        return ownerId.getUserId();
    }
}
