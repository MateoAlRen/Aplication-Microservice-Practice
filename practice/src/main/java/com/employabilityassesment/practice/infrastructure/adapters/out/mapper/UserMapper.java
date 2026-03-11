package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.User;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity (User userModel);
    User toModel (UserEntity userEntity);
}
