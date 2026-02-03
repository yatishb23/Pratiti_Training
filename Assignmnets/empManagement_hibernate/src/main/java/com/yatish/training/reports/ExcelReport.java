package com.yatish.training.reports;

import com.yatish.training.models.EmployeeEntity;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.*;

public class ExcelReport {

    public static void generate(Optional<List<EmployeeEntity>> employees) {

        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Employees");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("State");
            header.createCell(3).setCellValue("Salary");
            header.createCell(4).setCellValue("Role");

            int rowNum = 1;
            for (EmployeeEntity e : employees.orElse(Collections.emptyList())) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(e.getId());
                row.createCell(1).setCellValue(e.getName());
                row.createCell(2).setCellValue(e.getState());
                row.createCell(3).setCellValue(e.calculateSalary());
                row.createCell(4).setCellValue(e.getRole());
            }

            FileOutputStream fos = new FileOutputStream("employees.xlsx");
            wb.write(fos);

            System.out.println("Excel report generated: employees.xlsx");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
