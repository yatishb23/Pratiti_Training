package com.yatish;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import com.yatish.JDBC.GetConnection;
import com.yatish.dao.EmployeeDAOImpl;
import com.yatish.model.EmployeeEntity;

public class Main {
    public static void main(String[] args) {
        Connection conn=GetConnection.getConneciton();
        EmployeeDAOImpl emp=new EmployeeDAOImpl();
        EmployeeEntity ee=new EmployeeEntity(1,"Yatish");
        // emp.addEmployee(ee);
        // showEmployee();
        getEmployeeById(1);
        // emp.getEmployeeById(1).stream().forEach(System.out::println);
        System.out.println("DB is connected....");
    }

    public static void getEmployeeById(Integer empId){
        EmployeeDAOImpl emp=new EmployeeDAOImpl();
        Optional<EmployeeEntity> emps= emp.getEmployeeById(empId);
        emps.ifPresent(
            e ->{
                System.out.println("ID: "+e.getEmpId() + " , Name: " + e.getEmpName());
            }
        );
    }

    public static void showEmployee(){
        EmployeeDAOImpl emp=new EmployeeDAOImpl();
        Optional<List<EmployeeEntity>> empsOpt= emp.showEmployee();
        empsOpt.ifPresentOrElse(
            emps -> {
                for (EmployeeEntity e : emps) {
                    System.out.println("ID: " + e.getEmpId() + ", Name: " + e.getEmpName());
                }
            },
            () -> System.out.println("No employees found!")
        );
    }
}