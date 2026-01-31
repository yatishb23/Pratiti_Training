package com.yatish.training.services;

import java.util.Collection;

import com.yatish.training.models.Employee;

public interface EmployeeService {

    void addEmployee();
    void updateEmployee();
    void deleteEmployee();


    Collection<Employee> getAll();
    Employee getById(int id);
    void getByName(String name);
    void getByState(String state);

    Object getRepo();
    void setRepo(Object repo);
}
