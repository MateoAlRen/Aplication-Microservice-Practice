package com.employabilityassesment.practice.domain.ports.out;

import com.employabilityassesment.practice.domain.model.Audit;

public interface AuditLogPort {
    void register(Audit audit);
}
