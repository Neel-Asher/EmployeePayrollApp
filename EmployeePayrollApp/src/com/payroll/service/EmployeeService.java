/**
 * ==========================================================
 * EmployeeService.java
 * ==========================================================
 * @author  : Neel Asher
 * @version : 1.0
 *
 * Description:
 * Handles business logic for employee registration.
 *
 * Responsibilities:
 * - Validate employee data
 * - Generate unique employee ID
 * - Encrypt passwords
 * - Create Employee and UserAccount objects
 * - Persist employee data
 *
 * OOP Concepts:
 * - Service Layer Pattern
 *
 * Package: com.payroll.service
 * ==========================================================
 */
package com.payroll.service;

import com.payroll.exception.ValidationException;
import com.payroll.model.Employee;
import com.payroll.model.UserAccount;
import com.payroll.repository.EmployeeRepository;
import com.payroll.util.IdGenerator;
import com.payroll.util.PasswordUtil;

public class EmployeeService {

    private EmployeeRepository repository = new EmployeeRepository();

    public Employee registerEmployee(String name, String email, String phone,
                                     double salary, String department,
                                     String username, String password) throws ValidationException {

        ValidationService.validateEmail(email);
        ValidationService.validatePhone(phone);
        ValidationService.validatePassword(password);

        String employeeId = IdGenerator.generateEmployeeId();
        String encryptedPassword = PasswordUtil.encryptPassword(password);

        UserAccount account = new UserAccount(username, encryptedPassword, "EMPLOYEE");
        Employee employee = new Employee(employeeId, name, email, phone, salary, department, account);

        repository.saveEmployee(employee);

        return employee;
    }
}