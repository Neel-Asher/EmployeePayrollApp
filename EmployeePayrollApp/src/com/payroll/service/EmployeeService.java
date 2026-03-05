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

import com.payroll.model.Employee;
import com.payroll.model.UserAccount;
import com.payroll.repository.EmployeeRepository;
import com.payroll.util.ValidationUtil;
import com.payroll.util.PasswordUtil;
import com.payroll.util.IdGenerator;
import com.payroll.exception.InvalidDataException;

public class EmployeeService {

    private EmployeeRepository repository = new EmployeeRepository();

    public Employee registerEmployee(String name,String email,String phone,double salary,String department,String username,String password) throws InvalidDataException {
        if (!ValidationUtil.validateEmail(email))
            throw new InvalidDataException("Invalid Email Format");

        if (!ValidationUtil.validatePhone(phone))
            throw new InvalidDataException("Invalid Phone Number");

        String employeeId = IdGenerator.generateEmployeeId();
        String encryptedPassword = PasswordUtil.encryptPassword(password);

        UserAccount account = new UserAccount(username,encryptedPassword,"EMPLOYEE");
        Employee employee = new Employee(employeeId,name,email,phone,salary,department,account);
        repository.saveEmployee(employee);

        return employee;
    }
}