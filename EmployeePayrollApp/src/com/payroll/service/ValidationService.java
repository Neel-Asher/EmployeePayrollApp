package com.payroll.service;

import com.payroll.util.ValidationUtil;
import com.payroll.exception.ValidationException;

public class ValidationService {

    public static void validateEmail(String email) throws ValidationException {
        if (!ValidationUtil.validateEmail(email)) {
            throw new ValidationException("Invalid Email Format");
        }
    }

    public static void validatePhone(String phone) throws ValidationException {
        if (!ValidationUtil.validatePhone(phone)) {
            throw new ValidationException("Invalid Phone Number");
        }
    }

    public static void validatePassword(String password) throws ValidationException {
        // Minimum 8 chars, at least 1 uppercase, 1 lowercase, 1 digit, 1 special char
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        if (!password.matches(pattern)) {
            throw new ValidationException("Password must be 8+ chars, include uppercase, lowercase, digit, special char");
        }
    }

    public static void validateEmployeeId(String employeeId) throws ValidationException {
        String pattern = "^EMP\\d{4,}$";
        if (!employeeId.matches(pattern)) {
            throw new ValidationException("Employee ID must start with 'EMP' followed by at least 4 digits");
        }
    }
}