package com.employabilityassesment.practice.infrastructure.adapters.in.webmapper;

import com.employabilityassesment.practice.domain.model.User;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.request.UserRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface UserWebMapper {
    @Mapping(target = "userId", ignore = true)
    User toModel (UserRegisterRequest user);
}
