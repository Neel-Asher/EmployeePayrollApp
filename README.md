# EmployeePayrollApp
Develop an Employee Payroll Management System that serves as a hands-on laboratory for mastering Object-Oriented Programming (OOP) concepts through real-world enterprise application development. The application demonstrates how core OOP principles solve complex business problems while maintaining code quality, scalability, and maintainability.

## Use Case 1 – Employee Registration

### Overview

Use Case 1 implements the **Employee Registration module** of the Employee Payroll Management System.
This module allows a new employee to register in the system by providing validated personal, contact, and salary information.
The system verifies the input using **regular expression validation**, generates a **unique employee ID**, creates associated **user credentials**, and stores the employee record.

---

### Primary Actor

* **New Employee**

### Secondary Actor

* **System Administrator**

---

### Goal

Register a new employee in the payroll system with validated information and securely stored login credentials.

---

### Flow of Execution

1. User enters employee details (name, email, phone, department, salary).
2. System validates email and phone using **regular expressions**.
3. A **unique employee ID** is generated automatically.
4. Password is encrypted using **SHA-256 hashing**.
5. The system creates:

   * `Employee` object
   * `UserAccount` object
6. Employee information is persisted in the repository.
7. System displays **registration confirmation**.

---

### Classes Involved

| Class                  | Responsibility                                             |
| ---------------------- | ---------------------------------------------------------- |
| `PayrollApplication`   | Main class that handles user input and application flow    |
| `Employee`             | Stores employee information and encapsulates employee data |
| `UserAccount`          | Stores login credentials and role                          |
| `EmployeeService`      | Contains business logic for employee registration          |
| `EmployeeRepository`   | Simulates data persistence using a collection              |
| `ValidationUtil`       | Performs input validation using regex                      |
| `PasswordUtil`         | Encrypts passwords using SHA-256                           |
| `IdGenerator`          | Generates unique employee IDs                              |
| `InvalidDataException` | Custom exception for invalid input                         |

---

### OOP Concepts Demonstrated

* **Encapsulation** – Employee data stored using private fields with controlled access.
* **Constructor Overloading** – Flexible object creation.
* **Method Overriding** – `toString()` used to display employee details.
* **Composition** – `Employee` has a `UserAccount`.
* **Exception Handling** – Custom exception for validation failures.
* **Layered Architecture** – Separation of App, Service, Repository, Model, and Utility layers.

---

### Validation Rules

* Email must match standard email format.
* Phone number must contain **exactly 10 digits**.
* Salary must be a positive numeric value.

---

### Example Output

```
Enter Name: John
Enter Email: john@gmail.com
Enter Phone: 9876543210
Enter Salary: 60000
Enter Department: IT
Enter Username: john123
Enter Password: pass123

Employee Registered Successfully

Employee ID: EMP1001
Name: John
Email: john@gmail.com
Phone: 9876543210
Department: IT
Salary: 60000
Username: john123
```

---

### Version

**Version:** 1.0

### Author

**Neel Asher**

---

### Learning Outcome

This use case demonstrates how **Object-Oriented Programming concepts can be applied to a real-world enterprise scenario**, ensuring data validation, security, modularity, and maintainability in an employee payroll system.
