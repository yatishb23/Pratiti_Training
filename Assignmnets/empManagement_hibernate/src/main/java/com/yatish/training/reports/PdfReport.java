package com.yatish.training.reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yatish.training.models.EmployeeEntity;

public class PdfReport {

    public static void generate(Optional<List<EmployeeEntity>> employees) {

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("employees.pdf"));
            doc.open();

            doc.add(new Paragraph("Employee Report\n\n"));

            PdfPTable table = new PdfPTable(4);
            table.addCell("ID");
            table.addCell("Name");
            table.addCell("State");
            table.addCell("Salary");
            table.addCell("Role");

            for (EmployeeEntity e : employees.orElse(Collections.emptyList())) {
                table.addCell(String.valueOf(e.getId()));
                table.addCell(e.getName());
                table.addCell(e.getState());
                table.addCell(String.valueOf(e.calculateSalary()));
                table.addCell(e.getRole());
            }

            doc.add(table);
            doc.close();

            System.out.println("PDF report generated: employees.pdf");

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
