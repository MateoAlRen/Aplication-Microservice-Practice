package com.employabilityassesment.practice.domain.exception;

public class UserNotValidated extends RuntimeException {
    public UserNotValidated(String message) {
        super(message);
    }
}
