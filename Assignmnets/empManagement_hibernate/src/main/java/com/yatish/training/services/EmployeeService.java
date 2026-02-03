package com.yatish.training.services;

import java.util.Collection;

import com.yatish.training.models.EmployeeEntity;

public interface EmployeeService {

    void addEmployee();
    void updateEmployee();
    void deleteEmployee();


    void getAllEmployees();
    void getEmployeeById();
    void getEmployeeByName();
    void getEmployeeByState();

}
