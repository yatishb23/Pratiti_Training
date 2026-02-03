package com.yatish.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Fname;
    private String Lname;
    private String city;

    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", city=" + city + "]";
    }
}
