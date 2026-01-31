package com.yatish.training.reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yatish.training.models.Employee;

public class PdfReport {

    public static void generate(Collection<Employee> employees) {

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

            for (Employee e : employees) {
                table.addCell(String.valueOf(e.getId()));
                table.addCell(e.getName());
                table.addCell(e.getState());
                table.addCell(String.valueOf(e.calculateSalary()));
            }

            doc.add(table);
            doc.close();

            System.out.println("PDF report generated: employees.pdf");

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
