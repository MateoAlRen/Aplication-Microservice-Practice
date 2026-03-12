package com.employabilityassesment.practice.infrastructure.adapters.out.adapter;

import com.employabilityassesment.practice.domain.model.User;
import com.employabilityassesment.practice.domain.ports.out.UserRepositoryPort;
import com.employabilityassesment.practice.infrastructure.adapters.out.UserJpaRepository;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.UserEntity;
import com.employabilityassesment.practice.infrastructure.adapters.out.mapper.UserMapper;
import com.employabilityassesment.practice.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    @Override
    public String saveUser(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity userSaved = userJpaRepository.save(userEntity);
        return jwtService.generateToken(userSaved.getUserId());
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.toModel(userJpaRepository.findByUserEmail(email));
    }
}
