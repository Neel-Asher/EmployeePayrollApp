/**
 * ==========================================================
 * ValidationUtil.java
 * ==========================================================
 * @author  : Neel Asher
 * @version : 1.0
 *
 * Description:
 * Utility class that performs input validation using
 * Regular Expressions.
 *
 * Responsibilities:
 * - Validate email format
 * - Validate phone numbers
 *
 * Package: com.payroll.util
 * ==========================================================
 */

package com.payroll.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_REGEX = "^[0-9]{10}$";

    public static boolean validateEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean validatePhone(String phone) {
        return Pattern.matches(PHONE_REGEX, phone);
    }
}