package com.payroll.model;

import java.time.Month;
import java.util.Objects;

public class Payslip implements Cloneable {

    private Employee employee;              // Aggregation: Employee
    private SalaryComponents components;    // Composition: SalaryComponents
    private Month month;
    private int year;

    public Payslip(Employee employee, SalaryComponents components, Month month, int year) {
        this.employee = employee;
        // Deep copy to ensure original SalaryComponents isn't modified
        this.components = new SalaryComponents()
                .setBasic(components.getBasic())
                .setHra(components.getHra())
                .setAllowances(components.getAllowances())
                .setPf(components.getPf())
                .setTax(components.getTax())
                .setNetPay(components.getNetPay());
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

    @Override
    public Payslip clone() {
        try {
            Payslip cloned = (Payslip) super.clone();
            // Deep clone SalaryComponents
            cloned.components = new SalaryComponents()
                    .setBasic(this.components.getBasic())
                    .setHra(this.components.getHra())
                    .setAllowances(this.components.getAllowances())
                    .setPf(this.components.getPf())
                    .setTax(this.components.getTax())
                    .setNetPay(this.components.getNetPay());
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed for Payslip");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payslip)) return false;
        Payslip payslip = (Payslip) o;
        return year == payslip.year &&
               Objects.equals(employee.getEmployeeId(), payslip.employee.getEmployeeId()) &&
               month == payslip.month &&
               Objects.equals(components.getNetPay(), payslip.components.getNetPay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee.getEmployeeId(), month, year, components.getNetPay());
    }
}