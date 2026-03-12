package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.User;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-12T03:39:16-0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(User userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId( userModel.getUserId() );
        userEntity.setUserName( userModel.getUserName() );
        userEntity.setUserEmail( userModel.getUserEmail() );
        userEntity.setPassword( userModel.getPassword() );

        return userEntity;
    }

    @Override
    public User toModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userEntity.getUserId() );
        user.setUserName( userEntity.getUserName() );
        user.setUserEmail( userEntity.getUserEmail() );
        user.setPassword( userEntity.getPassword() );

        return user;
    }
}
