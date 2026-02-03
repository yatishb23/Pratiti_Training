package com.yatish.training;

import com.yatish.training.services.EmployeeServiceImpl;
import com.yatish.training.services.AuthenticationService;
import com.yatish.training.util.MenuUtil;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        AuthenticationService authService = new AuthenticationService();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Scanner sc = new Scanner(System.in);
        int choice;

        // Welcome and login/register
        System.out.println("====== EMPLOYEE MANAGEMENT SYSTEM ======");
        boolean loggedIn = false;
        
        while (!loggedIn) {
            System.out.println("\n1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int authChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (authChoice) {
                case 1 -> loggedIn = authService.login();
                case 2 -> {
                    authService.register();
                    System.out.println("Now try logging in.");
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }

        // Main menu after login
        while (true) {
            MenuUtil.mainMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> employeeService.addEmployee();
                case 2 -> MenuUtil.viewMenu(employeeService);
                case 3 -> employeeService.updateEmployee();
                case 4 -> employeeService.deleteEmployee();
                case 5 -> MenuUtil.reportMenu(employeeService);
                case 6 -> {
                    authService.logout();
                    System.out.println("Exiting to login screen...");
                    loggedIn = false;
                    while (!loggedIn) {
                        System.out.println("\n1. Login");
                        System.out.println("2. Register");
                        System.out.println("3. Exit");
                        System.out.print("Choose: ");
                        int authChoice = sc.nextInt();
                        sc.nextLine();

                        switch (authChoice) {
                            case 1 -> loggedIn = authService.login();
                            case 2 -> {
                                authService.register();
                                System.out.println("Now try logging in.");
                            }
                            case 3 -> {
                                System.out.println("Exiting...");
                                sc.close();
                                return;
                            }
                            default -> System.out.println("Invalid choice");
                        }
                    }
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
