package com.employabilityassesment.practice.infrastructure.adapters.out.adapter;

import com.employabilityassesment.practice.domain.model.Audit;
import com.employabilityassesment.practice.domain.model.AuditAction;
import com.employabilityassesment.practice.domain.ports.out.AuditLogPort;
import com.employabilityassesment.practice.infrastructure.adapters.out.AuditJpaRepository;
import com.employabilityassesment.practice.infrastructure.adapters.out.mapper.AuditMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuditLogPortAdapter implements AuditLogPort {
    private final AuditJpaRepository auditJpaRepository;
    private final AuditMapper auditMapper;

    @Override
    public void register(Audit audit) {
        auditJpaRepository.save(auditMapper.toEntity(audit));
    }
}
