package com.yatish.ems.models;

public class Developer extends Employee {

    public Developer(String name, String city, String state,String role) {
        super(name, city, state,role);
    }

    @Override
    public double calculateSalary() {
        return super.baseSalary * 1.5;
    }
}
