package com.employabilityassesment.practice.infrastructure.adapters.out.adapter;

import com.employabilityassesment.practice.domain.ports.out.NotificationPort;
import org.springframework.stereotype.Component;

@Component
public class NotificationPortAdapter implements NotificationPort {
    @Override
    public void sendNotification(String message) {
        System.out.println(message);
    }
}
