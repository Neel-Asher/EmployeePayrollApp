package com.payroll.service;

import com.payroll.model.Payslip;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileService {

    private static final String FILE_DIR = "Payslips/";

    public String savePayslip(Payslip payslip) {
        // Clone to preserve original
        Payslip copy = payslip.clone();

        // Generate unique filename: EMPID_MonthYear_timestamp.txt
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = FILE_DIR + copy.getEmployee().getEmployeeId() + "_"
                + copy.getMonth() + copy.getYear() + "_" + timestamp + ".txt";

        try {
            // Ensure directory exists
            java.nio.file.Files.createDirectories(java.nio.file.Paths.get(FILE_DIR));

            FileWriter writer = new FileWriter(filename);
            writer.write(copy.toString());
            writer.close();

            return filename;

        } catch (IOException e) {
            throw new RuntimeException("Failed to save payslip: " + e.getMessage());
        }
    }
}