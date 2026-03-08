package com.payroll.service;

import com.payroll.interfaces.Dashboard;
import com.payroll.model.Employee;
import com.payroll.model.Payslip;
import com.payroll.repository.PayslipRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardService implements Dashboard {

    private PayslipRepository payslipRepository;

    public DashboardService(PayslipRepository repository) {
        this.payslipRepository = repository;
    }

    @Override
    public void showRecentPayslips(Employee employee) {
        List<Payslip> recentPayslips = payslipRepository.getPayslipsForEmployee(employee)
                .stream()
                .sorted(Comparator.comparing(Payslip::getYear)
                        .thenComparing(Payslip::getMonth).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\n--- Recent Payslips (Top 3) ---");
        recentPayslips.forEach(System.out::println);
    }

    @Override
    public void showYTDEarnings(Employee employee) {
        double ytd = payslipRepository.getPayslipsForEmployee(employee)
                .stream()
                .mapToDouble(p -> p.getComponents().getNetPay())
                .sum();

        System.out.println("\nYear-to-Date Earnings: " + ytd);
    }
}