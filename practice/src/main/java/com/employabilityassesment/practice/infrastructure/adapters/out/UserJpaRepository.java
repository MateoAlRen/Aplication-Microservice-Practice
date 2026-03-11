package com.employabilityassesment.practice.infrastructure.adapters.out;

import com.employabilityassesment.practice.infrastructure.adapters.out.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
}
