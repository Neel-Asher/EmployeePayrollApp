package com.payroll.exception;

public class ValidationException extends InvalidDataException {
    public ValidationException(String message) {
        super(message);
    }
}