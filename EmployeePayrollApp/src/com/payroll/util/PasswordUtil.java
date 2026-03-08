/**
 * ==========================================================
 * PasswordUtil.java
 * ==========================================================
 * @author  : Neel Asher
 * @version : 1.0
 *
 * Description:
 * Provides password encryption functionality using SHA-256.
 *
 * Responsibilities:
 * - Encrypt plaintext passwords
 * - Return hashed value
 *
 * Package: com.payroll.util
 * ==========================================================
 */

package com.payroll.util;

import java.security.MessageDigest;

public class PasswordUtil {

    public static String encryptPassword(String password) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            StringBuilder hex = new StringBuilder();

            for (byte b : hash)
                hex.append(String.format("%02x", b));

            return hex.toString();

        } catch (Exception e) {
            throw new RuntimeException("Password encryption failed");
        }
    }

    public static boolean verifyPassword(String rawPassword, String storedHash) {

        String encryptedInput = encryptPassword(rawPassword);

        return encryptedInput.equals(storedHash);
    }
}