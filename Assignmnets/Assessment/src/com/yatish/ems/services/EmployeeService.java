package com.yatish.ems.services;

import java.util.Collection;

import com.yatish.ems.models.Employee;

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
