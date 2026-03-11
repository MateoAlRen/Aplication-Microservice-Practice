package com.employabilityassesment.practice.infrastructure.adapters.out.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table (name = "tasks")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID taskId = UUID.randomUUID();

    @OneToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;


    @Column(nullable = false)
    private String taskTitle;

    @Column(nullable = false)
    private boolean isCompleted;

    @Column(nullable = false)
    private boolean isDeleted;
}
