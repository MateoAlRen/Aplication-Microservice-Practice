package com.employabilityassesment.practice.infrastructure.adapters.out;

import com.employabilityassesment.practice.infrastructure.adapters.out.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskJpaRepository extends JpaRepository<TaskEntity, UUID> {
}
