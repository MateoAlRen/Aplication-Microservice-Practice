package com.employabilityassesment.practice.domain.ports.in;

public interface CreateUserUseCase {
    String saveUser (String userName, String userEmail, String password);
}
