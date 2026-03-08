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
import com.payroll.model.RegularEmployee;
import com.payroll.model.Manager;
import com.payroll.service.EmployeeService;
import com.payroll.service.AuthenticationService;
import com.payroll.service.PayrollService;
import com.payroll.repository.EmployeeRepository;
import com.payroll.exception.InvalidDataException;
import com.payroll.exception.AuthenticationException;
import com.payroll.session.SessionManager;

import java.time.Month;
import java.util.Scanner;

public class PayrollApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService();
        AuthenticationService authService = new AuthenticationService(repository);
        SessionManager sessionManager = new SessionManager();
        PayrollService payrollService = new PayrollService();

        while (true) {
            System.out.println("\n=== Employee Payroll System ===");
            System.out.println("1. Register Employee");
            System.out.println("2. Login");
            System.out.println("3. Generate Payslip");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": // UC1 Registration
                    try {
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter Phone: ");
                        String phone = scanner.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = Double.parseDouble(scanner.nextLine());

                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();

                        System.out.print("Enter Username: ");
                        String username = scanner.nextLine();

                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();

                        Employee employee = employeeService.registerEmployee(
                                name, email, phone, salary, department, username, password
                        );

                        repository.saveEmployee(employee);

                        System.out.println("\nEmployee Registered Successfully!");
                        System.out.println(employee);

                    } catch (InvalidDataException e) {
                        System.out.println("Registration Failed: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary input.");
                    }
                    break;

                case "2": // UC2 Login
                    try {
                        System.out.print("Enter Username: ");
                        String username = scanner.nextLine();

                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();

                        User user = authService.login(username, password);
                        sessionManager.createSession(user);

                        System.out.println("\nLogin Successful!");
                        System.out.println("Welcome, " + user.getUsername() + " (" + user.getRole() + ")");

                        if (user instanceof Manager) {
                            System.out.println("Accessing Manager Dashboard...");
                        } else if (user instanceof RegularEmployee) {
                            System.out.println("Accessing Employee Dashboard...");
                        }

                    } catch (AuthenticationException e) {
                        System.out.println("Login Failed: " + e.getMessage());
                    }
                    break;

                case "3": // UC3 Payslip
                    try {
                        if (!sessionManager.isActive()) {
                            System.out.println("Please login first to generate payslip.");
                            break;
                        }

                        User currentUser = sessionManager.getCurrentUser();
                        Employee employee = repository.findByUsername(currentUser.getUsername());

                        System.out.print("Enter Month (1-12): ");
                        int monthInt = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Year (e.g., 2026): ");
                        int year = Integer.parseInt(scanner.nextLine());

                        Month month = Month.of(monthInt);

                        System.out.println("\nGenerating Payslip...\n");
                        System.out.println(payrollService.generatePayslip(employee, month, year));

                    } catch (Exception e) {
                        System.out.println("Payslip Generation Failed: " + e.getMessage());
                    }
                    break;

                case "4":
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