package com.employabilityassesment.practice.infrastructure.adapters.in.webmapper;

import com.employabilityassesment.practice.domain.model.User;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.UserRegisterRequest;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface UserWebMapper {
    User toModel (UserRegisterRequest user);
}
