package com.yatish.dao;

import org.junit.jupiter.api.Test;

public class EmployeeDAOTest {
    @Test
    public static void main(String[] args) {
        EmployeeDAO emp=new EmployeeDAOImpl();
        // emp.addEmployee(new EmployeeEntity(2,"Pawan","Washim"));
        emp.getEmployeeById(1);
    }
}