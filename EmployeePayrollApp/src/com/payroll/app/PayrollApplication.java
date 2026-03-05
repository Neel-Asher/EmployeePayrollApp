/**
 * ==========================================================
 * PayrollApplication.java
 * ==========================================================
 * @author : Neel Asher
 * @version : 1.0
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

import com.payroll.service.EmployeeService;
import com.payroll.model.Employee;
import com.payroll.exception.InvalidDataException;
import java.util.Scanner;

public class PayrollApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        try {

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            Employee employee = service.registerEmployee(
                    name, email, phone, salary, department, username, password
            );

            System.out.println("\nEmployee Registered Successfully\n");
            System.out.println(employee);

        } catch (InvalidDataException e) {
            System.out.println("Registration Failed: " + e.getMessage());
        }
    }
}