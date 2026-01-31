package com.yatish.ems.services;

import com.yatish.ems.models.*;
import com.yatish.ems.repository.EmployeeRepository;
import com.yatish.ems.util.ValidationUtil;

import java.util.Collection;

import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repo = new EmployeeRepository();
    private Scanner sc = new Scanner(System.in);

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
        if (!ValidationUtil.isValidType(type)) {
            System.out.println("Invalid employee type");
            return;
        }

        Employee e = (type == 1)
                ? new Manager(name, city, state, "Manager")
                : new Developer(name, city, state, "Developer");

        repo.save(e);
        System.out.println("Employee added successfully");
    }

    @Override
    public void updateEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        Employee e = repo.findById(id);
        if (e == null) {
            System.out.println("Employee not found");
            return;
        }
        System.out.println("Before: " + e);
        deleteEmployee();
        addEmployee();
    }

    @Override
    public void deleteEmployee() {
        System.out.print("Enter ID: ");
        repo.delete(sc.nextInt());
        System.out.println("Deleted");
    }

    @Override
    public Collection<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public Employee getById(int id) {
        return repo.findById(id);
    }

    @Override
    public void getByName(String name) {
        repo.findAll().stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    @Override
    public void getByState(String state) {
        repo.findAll().stream()
                .filter(e -> e.getState().equalsIgnoreCase(state))
                .forEach(System.out::println);
    }

    @Override
    public Object getRepo() {
        return repo;
    }

    @Override
    public void setRepo(Object repo) {
        this.repo = (EmployeeRepository) repo;
    }
}
