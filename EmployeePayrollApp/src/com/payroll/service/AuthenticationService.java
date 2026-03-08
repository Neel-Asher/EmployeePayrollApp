package com.payroll.service;

import com.payroll.model.Employee;
import com.payroll.model.RegularEmployee;
import com.payroll.model.Manager;
import com.payroll.model.User;
import com.payroll.repository.EmployeeRepository;
import com.payroll.exception.AuthenticationException;
import com.payroll.util.PasswordUtil;

public class AuthenticationService {

    private EmployeeRepository repository;
    private static final int MAX_ATTEMPTS = 3;
    private int attempts = 0;

    public AuthenticationService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public User login(String username, String password) throws AuthenticationException {

        if (attempts >= MAX_ATTEMPTS) {
            throw new AuthenticationException("Maximum login attempts exceeded");
        }

        Employee employee = repository.findByUsername(username);

        if (employee == null) {
            attempts++;
            throw new AuthenticationException("User not found");
        }

        boolean valid = PasswordUtil.verifyPassword(
                password,
                employee.getAccount().getEncryptedPassword()
        );

        if (!valid) {
            attempts++;
            throw new AuthenticationException("Invalid password");
        }

        attempts = 0;

        String role = employee.getAccount().getRole();

        if ("MANAGER".equalsIgnoreCase(role)) {
            return new Manager(employee.getAccount());
        }

        return new RegularEmployee(employee.getAccount());
    }
}