package com.payroll.service;

import com.payroll.model.Employee;
import com.payroll.model.Payslip;
import com.payroll.model.SalaryComponents;

import java.time.Month;

public class PayrollService {

    // Example statutory percentages
    private static final double PF_PERCENT = 0.12;   // 12% PF
    private static final double TAX_PERCENT = 0.10;  // 10% Tax

    public Payslip generatePayslip(Employee employee, Month month, int year) {

        double basic = employee.getSalary() * 0.5;         // 50% of salary
        double hra = employee.getSalary() * 0.3;           // 30% HRA
        double allowances = employee.getSalary() * 0.2;    // 20% allowances

        double pf = basic * PF_PERCENT;
        double tax = (basic + hra + allowances) * TAX_PERCENT;
        double netPay = (basic + hra + allowances) - (pf + tax);

        SalaryComponents components = new SalaryComponents()
                .setBasic(basic)
                .setHra(hra)
                .setAllowances(allowances)
                .setPf(pf)
                .setTax(tax)
                .setNetPay(netPay);

        return new Payslip(employee, components, month, year);
    }
}