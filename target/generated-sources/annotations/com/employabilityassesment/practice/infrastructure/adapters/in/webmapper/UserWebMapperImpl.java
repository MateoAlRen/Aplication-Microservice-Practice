package com.employabilityassesment.practice.infrastructure.adapters.in.webmapper;

import com.employabilityassesment.practice.domain.model.User;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.request.UserRegisterRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-13T13:35:53-0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Amazon.com Inc.)"
)
@Component
public class UserWebMapperImpl implements UserWebMapper {

    @Override
    public User toModel(UserRegisterRequest user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setUserName( user.userName() );
        user1.setUserEmail( user.userEmail() );
        user1.setPassword( user.password() );

        return user1;
    }
}
