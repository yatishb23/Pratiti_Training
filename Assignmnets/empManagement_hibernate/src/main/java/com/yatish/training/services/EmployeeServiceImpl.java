package com.yatish.training.services;

import com.yatish.training.dao.EmployeeDAOImpl;
import com.yatish.training.models.*;
import com.yatish.training.util.ValidationUtil;

import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAOImpl dao = new EmployeeDAOImpl();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void addEmployee() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        if (!ValidationUtil.isValidString(name)) {
            System.out.println("Invalid name");
            return;
        }

        System.out.print("City: ");
        String city = sc.nextLine();

        System.out.print("State: ");
        String state = sc.nextLine();

        System.out.print("Type (1.Manager 2.Developer): ");
        int type = sc.nextInt();
        sc.nextLine(); // consume newline

        if (!ValidationUtil.isValidType(type)) {
            System.out.println("Invalid employee type");
            return;
        }

        EmployeeEntity emp = (type == 1)
                ? new Manager(name, city, state, "Manager")
                : new Developer(name, city, state, "Developer");

        dao.addEmployee(emp)
           .ifPresent(e -> System.out.println("Added: " + e));
    }

    @Override
    public void updateEmployee() {
        dao.updateEmployeeById();
    }

    @Override
    public void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        dao.deleteEmployeeById(id);
    }

    @Override
    public void getAllEmployees() {
        dao.getAllEmployees().ifPresent(list -> {
            if (CurrentUser.getInstance().isAdmin()) {
                list.forEach(System.out::println);
            } else {
                list.stream()
                    .filter(e -> e.getCreatedByUserId() ==
                            CurrentUser.getInstance().getCurrentUserId())
                    .forEach(System.out::println);
            }
        });
    }

    @Override
    public void getEmployeeById() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        dao.getEmployeeById(id).ifPresentOrElse(
            emp -> {
                if (CurrentUser.getInstance().isAdmin() ||
                    emp.getCreatedByUserId() ==
                    CurrentUser.getInstance().getCurrentUserId()) {
                    System.out.println(emp);
                } else {
                    System.out.println("Permission Denied!");
                }
            },
            () -> System.out.println("Employee not found")
        );
    }

    @Override
    public void getEmployeeByName() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        dao.getEmployeeByName(name).ifPresent(list -> {
            if (CurrentUser.getInstance().isAdmin()) {
                list.forEach(System.out::println);
            } else {
                list.stream()
                    .filter(e -> e.getCreatedByUserId() ==
                            CurrentUser.getInstance().getCurrentUserId())
                    .forEach(System.out::println);
            }
        });
    }

    @Override
    public void getEmployeeByState() {
        System.out.print("Enter State: ");
        String state = sc.nextLine();

        dao.getEmployeeByState(state).ifPresent(list -> {
            if (CurrentUser.getInstance().isAdmin()) {
                list.forEach(System.out::println);
            } else {
                list.stream()
                    .filter(e -> e.getCreatedByUserId() ==
                            CurrentUser.getInstance().getCurrentUserId())
                    .forEach(System.out::println);
            }
        });
    }
}
