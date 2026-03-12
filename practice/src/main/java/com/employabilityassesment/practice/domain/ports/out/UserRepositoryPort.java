package com.employabilityassesment.practice.domain.ports.out;

import com.employabilityassesment.practice.domain.model.User;

public interface UserRepositoryPort {
    String saveUser(User user);
    User findByEmail (String userEmail);
}
