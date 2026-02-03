package com.yatish.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yatish.model.EmployeeDTO;
import com.yatish.service.EmployeeServiceImpl;

public class EmployeeView {

    private EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

    private static final Logger logger =
            LogManager.getLogger(EmployeeView.class);

    public EmployeeView() {
        addEmployee();
        getEmployeeById();
        getAllEmployees();
        getByCity();
        deleteEmployeeById();
    }

    private void getByCity() {
        String city = "Pune";
        employeeServiceImpl.getByCity(city).ifPresent(list -> list.forEach(System.out::println));
    }

    public void addEmployee() {
        EmployeeDTO e = new EmployeeDTO("Yatish", "Badgujar","Pune");
        EmployeeDTO e1 = new EmployeeDTO("Amit", "Kumar","Mumbai");
        EmployeeDTO e2 = new EmployeeDTO("Saurabh", "Shinde","Pune");

        employeeServiceImpl.addEmployee(e);
        employeeServiceImpl.addEmployee(e1);
        employeeServiceImpl.addEmployee(e2);
        
        logger.info("Employee added successfully");
    }
    public void getEmployeeById() {
        int id = 1;
        employeeServiceImpl.getEmployeeById(id).stream().forEach(System.out::println);
    }

    public void getAllEmployees() {
        employeeServiceImpl.getAllEmployees().ifPresent(list -> list.forEach(System.out::println));
    }
    public void deleteEmployeeById() {
        int id = 2;
        employeeServiceImpl.deleteEmployeeById(id);
        logger.info("Employee deleted successfully with id: {}", id);
    }
}
