package com.yatish;

import com.yatish.services.*;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add  2.View  3.Update  4.Delete  5.Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.addEmployee();
                    break;
                case 2:
                    service.viewEmployees();
                    break;
                case 3:
                    service.updateEmployee();
                    break;
                case 4:
                    service.deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
            
            
        }
    }
}
