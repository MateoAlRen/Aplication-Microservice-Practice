package com.employabilityassesment.practice.infrastructure.adapters.out.entity;

import com.employabilityassesment.practice.domain.model.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table (name = "projects")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID projectId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;

    @Column (nullable = false)
    private String projectName;

    @Column (nullable = false)
    private ProjectStatus projectStatus;

    @Column (nullable = false)
    private boolean isDeleted;
}
