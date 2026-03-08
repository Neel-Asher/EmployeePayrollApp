package com.payroll.model;

import java.time.Month;

public class Payslip {

    private Employee employee;              // Aggregation: Employee
    private SalaryComponents components;    // Composition: SalaryComponents
    private Month month;
    private int year;

    public Payslip(Employee employee, SalaryComponents components, Month month, int year) {
        this.employee = employee;
        this.components = components;
        this.month = month;
        this.year = year;
    }

    public Employee getEmployee() { return employee; }
    public SalaryComponents getComponents() { return components; }
    public Month getMonth() { return month; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return "====== PAYSLIP ======\n" +
                "Employee ID: " + employee.getEmployeeId() + "\n" +
                "Name: " + employee.getName() + "\n" +
                "Department: " + employee.getDepartment() + "\n" +
                "Month/Year: " + month + "/" + year + "\n" +
                "---------------------\n" +
                components.toString() + "\n" +
                "=====================";
    }
}