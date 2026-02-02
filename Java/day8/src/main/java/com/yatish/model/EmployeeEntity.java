package com.yatish.model;

public class EmployeeEntity {
    private int empId;
    private String empName;
    
    public EmployeeEntity(int empId, String empName) {
        this.empId = empId;
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

    @Override
    public String toString() {
        return "[empId=" + empId + ", empName=" + empName + "]";
    }
    
}
