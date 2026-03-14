package com.employabilityassesment.practice.infrastructure.adapters.out.mapper;

import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.infrastructure.adapters.out.entity.AuditEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface AuditMapper {
    AuditEntity toEntity(Audit audit);
    Audit toModel (AuditEntity auditEntity);
}
