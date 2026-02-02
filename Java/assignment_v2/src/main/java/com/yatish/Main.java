package com.yatish;

import com.yatish.dao.EmployeeDAO;
import com.yatish.dao.EmployeeDAOImpl;
import com.yatish.entity.EmployeeEntity;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO emp=new EmployeeDAOImpl();
        emp.addEmployee(new EmployeeEntity(1,"Yatish","Pune"));
        emp.getEmployeeById(1).ifPresent(
            e->{
                System.err.println(e);
            }
        );
    }
}