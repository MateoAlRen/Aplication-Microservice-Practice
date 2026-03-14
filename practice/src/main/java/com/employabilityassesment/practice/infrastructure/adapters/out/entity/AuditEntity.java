package com.employabilityassesment.practice.infrastructure.adapters.out.entity;

import com.employabilityassesment.practice.domain.model.AuditAction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table (name = "audit")
@Getter @Setter
@AllArgsConstructor
public class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID auditId;

    @Column(nullable = true)
    private final UUID userId;

    @Column(nullable = true)
    private final UUID entityId;

    @Column(nullable = false)
    private final AuditAction auditAction;
}
