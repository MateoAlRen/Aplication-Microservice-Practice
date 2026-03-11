package com.employabilityassesment.practice.infrastructure.adapters.out;

import com.employabilityassesment.practice.infrastructure.adapters.out.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectJpaRepository extends JpaRepository<ProjectEntity, UUID> {
}
