/**
 * ==========================================================
 * InvalidDataException.java
 * ==========================================================
 * @author  : Neel Asher
 * @version : 1.0
 *
 * Description:
 * Custom exception thrown when employee data
 * fails validation rules.
 *
 * Package: com.payroll.exception
 * ==========================================================
 */

package com.payroll.exception;

public class InvalidDataException extends Exception {

    public InvalidDataException(String message) {
        super(message);
    }
}