/**
 * ==========================================================
 * PayrollApplication.java
 * ==========================================================
 * @author  : Neel Asher
 * @version : 3.0
 *
 * Description:
 * This is the main entry point of the Employee Payroll
 * Management System application.
 *
 * Responsibilities:
 * - Accept user input for employee registration
 * - Invoke business logic through EmployeeService
 * - Handle exceptions and display system responses
 *
 * OOP Concepts Demonstrated:
 * - Separation of Concerns
 * - Layered Architecture
 *
 * Package: com.payroll.app
 * ==========================================================
 */

package com.payroll.app;

import com.payroll.model.Employee;
import com.payroll.model.User;
import com.payroll.repository.EmployeeRepository;
import com.payroll.repository.PayslipRepository;
import com.payroll.service.*;
import com.payroll.interfaces.Dashboard;
import com.payroll.exception.InvalidDataException;
import com.payroll.exception.AuthenticationException;
import com.payroll.session.SessionManager;

import java.time.Month;
import java.util.Scanner;

public class PayrollApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeRepository employeeRepository = new EmployeeRepository();
        PayslipRepository payslipRepository = new PayslipRepository();
        EmployeeService employeeService = new EmployeeService();
        AuthenticationService authService = new AuthenticationService(employeeRepository);
        SessionManager sessionManager = new SessionManager();
        PayrollService payrollService = new PayrollService();
        FileService fileService = new FileService();
        Dashboard dashboardService = new DashboardService(payslipRepository);

        while (true) {
            System.out.println("\n=== Employee Payroll System ===");
            System.out.println("1. Register Employee");
            System.out.println("2. Login");
            System.out.println("3. Generate Payslip");
            System.out.println("4. Download Payslip");
            System.out.println("5. View Dashboard");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    // UC1 Registration logic remains same
                    break;

                case "2":
                    // UC2 Login logic remains same
                    break;

                case "3":
                    // UC3 Generate Payslip logic
                    try {
                        if (!sessionManager.isActive()) {
                            System.out.println("Please login first to generate payslip.");
                            break;
                        }

                        User currentUser = sessionManager.getCurrentUser();
                        Employee employee = employeeRepository.findByUsername(currentUser.getUsername());

                        System.out.print("Enter Month (1-12): ");
                        int monthInt = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Year (e.g., 2026): ");
                        int year = Integer.parseInt(scanner.nextLine());

                        Month month = Month.of(monthInt);
                        var payslip = payrollService.generatePayslip(employee, month, year);
                        payslipRepository.savePayslip(payslip);

                        System.out.println("\nGenerated Payslip:\n");
                        System.out.println(payslip);

                    } catch (Exception e) {
                        System.out.println("Payslip Generation Failed: " + e.getMessage());
                    }
                    break;

                case "4":
                    // UC4 Download Payslip logic remains same
                    break;

                case "5": // UC5 View Dashboard
                    try {
                        if (!sessionManager.isActive()) {
                            System.out.println("Please login first to view dashboard.");
                            break;
                        }

                        User currentUser = sessionManager.getCurrentUser();
                        Employee employee = employeeRepository.findByUsername(currentUser.getUsername());

                        System.out.println("\n--- Dashboard ---");
                        dashboardService.showRecentPayslips(employee);
                        dashboardService.showYTDEarnings(employee);

                    } catch (Exception e) {
                        System.out.println("Dashboard display failed: " + e.getMessage());
                    }
                    break;

                case "6":
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}