package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.AuditAction;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.AuditEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-14T18:17:49-0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Amazon.com Inc.)"
)
@Component
public class AuditMapperImpl implements AuditMapper {

    @Override
    public AuditEntity toEntity(Audit audit) {
        if ( audit == null ) {
            return null;
        }

        UUID auditId = null;
        UUID userId = null;
        UUID entityId = null;
        AuditAction auditAction = null;

        auditId = audit.getAuditId();
        userId = audit.getUserId();
        entityId = audit.getEntityId();
        auditAction = audit.getAuditAction();

        AuditEntity auditEntity = new AuditEntity( auditId, userId, entityId, auditAction );

        return auditEntity;
    }

    @Override
    public Audit toModel(AuditEntity auditEntity) {
        if ( auditEntity == null ) {
            return null;
        }

        UUID auditId = null;
        UUID userId = null;
        UUID entityId = null;
        AuditAction auditAction = null;

        auditId = auditEntity.getAuditId();
        userId = auditEntity.getUserId();
        entityId = auditEntity.getEntityId();
        auditAction = auditEntity.getAuditAction();

        Audit audit = new Audit( auditId, userId, entityId, auditAction );

        return audit;
    }
}
