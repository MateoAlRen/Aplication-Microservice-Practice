package com.employabilityassesment.practice.aplication.usescases;

import com.employabilityassesment.practice.domain.exception.InvalidCredentialsException;
import com.employabilityassesment.practice.domain.model.User;
import com.employabilityassesment.practice.domain.ports.in.LogInUseCase;
import com.employabilityassesment.practice.domain.ports.out.UserRepositoryPort;
import com.employabilityassesment.practice.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogInUseCaseImpl implements LogInUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final JwtService jwtService;

    @Override
    public String userLogin(String userEmail, String userPassword) {
        User userLogIn = userRepositoryPort.findByEmail(userEmail);

        if (userLogIn == null || !userPassword.equals(userLogIn.getPassword())){
            throw new InvalidCredentialsException("Email or password not valid!");
        }
        return jwtService.generateToken(userLogIn.getUserId());

    }
}
