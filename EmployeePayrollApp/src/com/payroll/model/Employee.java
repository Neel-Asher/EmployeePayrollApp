/**
 * ==========================================================
 * Employee.java
 * ==========================================================
 * @author  : Neel Asher
 * @version : 1.0
 *
 * Description:
 * Represents an Employee entity within the Payroll System.
 * This class encapsulates employee information and links
 * the employee to a UserAccount.
 *
 * Responsibilities:
 * - Store employee details
 * - Maintain encapsulation using private fields
 * - Provide getters and setters
 * - Override toString() for readable output
 *
 * OOP Concepts:
 * - Encapsulation
 * - Composition (Employee HAS-A UserAccount)
 *
 * Package: com.payroll.model
 * ==========================================================
 */

package com.payroll.model;

public class Employee {

    private String employeeId;
    private String name;
    private String email;
    private String phone;
    private double salary;
    private String department;
    private UserAccount account;

    public Employee() {}

    public Employee(String employeeId, String name, String email,
                    String phone, double salary,
                    String department, UserAccount account) {

        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.department = department;
        this.account = account;
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public UserAccount getAccount() { return account; }

    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(String department) { this.department = department; }
    public void setAccount(UserAccount account) { this.account = account; }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nPhone: " + phone +
                "\nDepartment: " + department +
                "\nSalary: " + salary +
                "\nUsername: " + account.getUsername();
    }
}