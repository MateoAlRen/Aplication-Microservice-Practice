package com.employabilityassesment.practice.infrastructure.adapters.out;

import com.employabilityassesment.practice.infrastructure.adapters.out.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectJpaRepository extends JpaRepository<ProjectEntity, UUID> {

    @Query("""
        SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END
        FROM TaskEntity t
        WHERE t.project.projectId = :projectId
        AND t.isCompleted = false
        AND t.isDeleted = false
    """)
    boolean hasActiveTask(@Param("projectId") UUID projectId);
    List<ProjectEntity> findByOwnerId_UserId(UUID ownerId);
}
