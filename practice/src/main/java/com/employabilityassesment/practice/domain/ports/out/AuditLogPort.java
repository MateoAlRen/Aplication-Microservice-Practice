package com.employabilityassesment.practice.domain.ports.out;

import java.util.UUID;

public interface AuditLogPort {
    void register(String action, UUID entityId);
}
