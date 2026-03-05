/**
 * ==========================================================
 * IdGenerator.java
 * ==========================================================
 * @author  : Neel Asher
 * @version : 1.0
 *
 * Description:
 * Generates unique employee IDs.
 *
 * Example Output:
 * EMP1001
 * EMP1002
 *
 * Package: com.payroll.util
 * ==========================================================
 */

package com.payroll.util;

public class IdGenerator {

    private static int counter = 1001;

    public static String generateEmployeeId() {
        return "EMP" + counter++;
    }
}