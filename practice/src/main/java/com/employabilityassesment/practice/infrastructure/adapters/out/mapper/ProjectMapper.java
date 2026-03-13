package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.Project;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.ProjectEntity;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "ownerId", source = "ownerId")
    ProjectEntity toEntity(Project project);

    @Mapping(target = "ownerId", source = "ownerId.userId")
    Project toModel(ProjectEntity entity);

    default UserEntity map(UUID userId) {
        if (userId == null) {
            return null;
        }
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        return user;
    }

    default UUID map(UserEntity user) {
        if (user == null) {
            return null;
        }
        return user.getUserId();
    }
}
