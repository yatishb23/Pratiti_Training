package com.yatish.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class EmployeeEntity {
    @Id
    private Integer empId;
    private String empName;
    private String empCity;

    public EmployeeEntity(Integer empId, String empName, String empCity) {
        this.empId = empId;
        this.empName = empName;
        this.empCity = empCity;
    }

    @Override
    public String toString() {
        return "EmployeeEntity [empId=" + empId + ", empName=" + empName + ", empCity=" + empCity + "]";
    }

    
}
