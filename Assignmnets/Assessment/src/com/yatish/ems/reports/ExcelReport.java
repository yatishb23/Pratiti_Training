package com.yatish.ems.reports;

import com.yatish.ems.models.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Collection;

public class ExcelReport {

    public static void generate(Collection<Employee> employees) {

        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Employees");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("State");
            header.createCell(3).setCellValue("Salary");

            int rowNum = 1;
            for (Employee e : employees) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(e.getId());
                row.createCell(1).setCellValue(e.getName());
                row.createCell(2).setCellValue(e.getState());
                row.createCell(3).setCellValue(e.calculateSalary());
            }

            FileOutputStream fos = new FileOutputStream("employees.xlsx");
            wb.write(fos);

            System.out.println("Excel report generated: employees.xlsx");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
