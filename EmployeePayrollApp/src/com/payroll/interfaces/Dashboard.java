package com.payroll.interfaces;

import com.payroll.model.Employee;

public interface Dashboard {

    // Display top 3 recent payslips
    void showRecentPayslips(Employee employee);

    // Display year-to-date earnings summary
    void showYTDEarnings(Employee employee);

}