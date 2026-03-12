package com.employabilityassesment.practice.infrastructure.adapters.out.adapter;

import com.employabilityassesment.practice.domain.ports.out.CurrentUserPort;
import com.employabilityassesment.practice.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CurrentUserAdapter implements CurrentUserPort {
    private final JwtService jwtService;

    @Override
    public UUID getCurrentUser() {
        String token = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
        return jwtService.getCurrentUser(token);
    }
}
