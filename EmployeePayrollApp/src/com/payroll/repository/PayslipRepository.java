package com.payroll.repository;

import com.payroll.model.Employee;
import com.payroll.model.Payslip;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PayslipRepository {

    private List<Payslip> payslips = new ArrayList<>();

    public void savePayslip(Payslip payslip) {
        payslips.add(payslip);
    }

    public List<Payslip> getPayslipsForEmployee(Employee employee) {
        return payslips.stream()
                .filter(p -> p.getEmployee().getEmployeeId().equals(employee.getEmployeeId()))
                .collect(Collectors.toList());
    }
}