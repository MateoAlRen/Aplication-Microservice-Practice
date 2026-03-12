package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.UserAlreadyExistsException;
import com.employabilityassesment.practice.domain.model.User;
import com.employabilityassesment.practice.domain.ports.in.CreateUserUseCase;
import com.employabilityassesment.practice.domain.ports.out.UserRepositoryPort;
import com.employabilityassesment.practice.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final JwtService jwtService;
    @Override
    public String saveUser(String userName, String userEmail, String password) {

        if (userRepositoryPort.findByEmail(userEmail) != null){
            throw new UserAlreadyExistsException("The user already exists!");
        }

        User user = new User(
                UUID.randomUUID(),
                userName,
                userEmail,
                password

        );

        userRepositoryPort.saveUser(user);
        return jwtService.generateToken(user.getUserId());
    }
}
