package com.yatish.training.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emp_type", discriminatorType = DiscriminatorType.STRING)
public abstract class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String name;
    protected String city;
    protected String state;
    protected double baseSalary = 15000;
    protected String role;
    protected int createdByUserId; 
    protected String createdByUsername;

    // REQUIRED by Hibernate
    public EmployeeEntity() {}

    public EmployeeEntity(String name, String city, String state, String role) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.role = role;
        this.createdByUserId = 0;
        this.createdByUsername = "";
    }

    public EmployeeEntity(String name, String city, String state, String role, int createdByUserId, String createdByUsername) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.role = role;
        this.createdByUserId = createdByUserId;
        this.createdByUsername = createdByUsername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getRole() {
        return role;
    }

    public int getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(int createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getCreatedByUsername() {
        return createdByUsername;
    }

    public void setCreatedByUsername(String createdByUsername) {
        this.createdByUsername = createdByUsername;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return id + " | " + name + " | " + city + " | " + state + " | " + role + " | " + calculateSalary();
    }
}
