package com.yatish.training.util;

import java.util.Scanner;

import com.yatish.training.reports.ExcelReport;
import com.yatish.training.reports.PdfReport;
import com.yatish.training.services.EmployeeService;

public class MenuUtil {

    public static void mainMenu() {
        System.out.println("""
                1. Add Employee
                2. View
                3. Update
                4. Delete
                5. Report
                6. Exit
                """);
    }

    public static void viewMenu(EmployeeService service) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.All 2.By ID 3.By Name 4.By State");
        int c = sc.nextInt();

        switch (c) {
            case 1 ->
                service.getAll().forEach(System.out::println);
            case 2 ->
                System.out.println(service.getById(sc.nextInt()));
            case 3 ->
                service.getByName(sc.next());
            case 4 ->
                service.getByState(sc.next());
        }
    }

    public static void reportMenu(EmployeeService service) {

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Excel Report");
        System.out.println("2. PDF Report");

        int choice = sc.nextInt();

        switch (choice) {
            case 1 ->
                ExcelReport.generate(service.getAll());
            case 2 ->
                PdfReport.generate(service.getAll());
            default ->
                System.out.println("Invalid option");
        }
    }

}
