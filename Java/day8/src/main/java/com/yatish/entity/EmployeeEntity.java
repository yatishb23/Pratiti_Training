package com.yatish.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_table1")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="eid")
    private int empId;
    
    @Column(name = "ename")
    private String empName;
  

    public EmployeeEntity() {
    }

    public EmployeeEntity(String empName) {
        this.empName = empName;
    }

   public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    
}
