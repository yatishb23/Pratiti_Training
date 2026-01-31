package com.yatish.training.models;

public class Manager extends Employee {

    public Manager(String name, String city, String state,String role) {
        super(name, city, state, role);
    }

    @Override
    public double calculateSalary() {
        return super.baseSalary * 2;
    }
}
