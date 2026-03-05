/**
 * ==========================================================
 * EmployeeRepository.java
 * ==========================================================
 * @author  : Neel Asher
 * @version : 1.0
 *
 * Description:
 * Simulates persistence of employee data.
 *
 * Responsibilities:
 * - Store employees in memory
 * - Retrieve employee list
 *
 * Package: com.payroll.repository
 * ==========================================================
 */

package com.payroll.repository;

import com.payroll.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public void saveEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}