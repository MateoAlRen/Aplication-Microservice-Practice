package com.employabilityassesment.practice.infrastructure.adapters.out;

import com.employabilityassesment.practice.infrastructure.adapters.out.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskJpaRepository extends JpaRepository<TaskEntity, UUID> {
    List<TaskEntity> findByProject_ProjectIdAndIsDeletedFalse(UUID projectId);
}
