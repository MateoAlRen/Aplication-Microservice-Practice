package com.employabilityassesment.practice.domain.model;

import java.util.UUID;

public class Audit {
    private final UUID auditId;
    private final UUID userId;
    private final UUID entityId;
    private final AuditAction auditAction;

    public Audit(UUID auditId, UUID userId, UUID entityId, AuditAction auditAction) {
        this.auditId = auditId;
        this.userId = userId;
        this.entityId = entityId;
        this.auditAction = auditAction;
    }

    public UUID getAuditId() {
        return auditId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public AuditAction getAuditAction() {
        return auditAction;
    }
}
