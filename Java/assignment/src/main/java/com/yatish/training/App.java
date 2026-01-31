package com.yatish.training;

import com.yatish.training.services.EmployeeServiceImpl;
import com.yatish.training.util.FileUtil;
import com.yatish.training.util.MenuUtil;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        EmployeeServiceImpl service = new EmployeeServiceImpl();
        FileUtil.load(service);

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            MenuUtil.mainMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> service.addEmployee();
                case 2 -> MenuUtil.viewMenu(service);
                case 3 -> service.updateEmployee();
                case 4 -> service.deleteEmployee();
                case 5 -> MenuUtil.reportMenu(service);
                case 6 -> {
                    FileUtil.save(service);
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
