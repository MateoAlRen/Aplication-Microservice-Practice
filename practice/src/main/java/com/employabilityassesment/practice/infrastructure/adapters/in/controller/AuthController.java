package com.employabilityassesment.practice.infrastructure.adapters.in.controller;

import com.employabilityassesment.practice.domain.exception.InvalidCredentialsException;
import com.employabilityassesment.practice.domain.exception.UserAlreadyExistsException;
import com.employabilityassesment.practice.domain.model.User;
import com.employabilityassesment.practice.domain.ports.in.CreateUserUseCase;
import com.employabilityassesment.practice.domain.ports.in.LogInUseCase;
import com.employabilityassesment.practice.domain.ports.out.UserRepositoryPort;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.AuthResponse;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.LoginRequest;
import com.employabilityassesment.practice.infrastructure.adapters.in.dto.UserRegisterRequest;
import com.employabilityassesment.practice.infrastructure.adapters.in.webmapper.UserWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final CreateUserUseCase createUserUseCase;
    private final LogInUseCase logInUseCase;
    private final UserWebMapper userWebMapper;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid UserRegisterRequest registerRequest){
        User userRegister = userWebMapper.toModel(registerRequest);
        return ResponseEntity.ok(new AuthResponse(createUserUseCase.saveUser(userRegister.getUserName(), userRegister.getUserEmail(), userRegister.getPassword())));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest loginRequest){
        String token = logInUseCase.userLogin(loginRequest.userEmail(),loginRequest.userPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }


}
