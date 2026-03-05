/**
 * ==========================================================
 * UserAccount.java
 * ==========================================================
 * @author  : Neel Asher
 * @version : 1.0
 *
 * Description:
 * Represents login credentials associated with an employee.
 *
 * Responsibilities:
 * - Store username
 * - Store encrypted password
 * - Maintain user role
 *
 * OOP Concepts:
 * - Composition with Employee
 *
 * Package: com.payroll.model
 * ==========================================================
 */

package com.payroll.model;

public class UserAccount {

    private String username;
    private String encryptedPassword;
    private String role;

    public UserAccount(String username, String encryptedPassword, String role) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getEncryptedPassword() { return encryptedPassword; }
    public String getRole() { return role; }
}