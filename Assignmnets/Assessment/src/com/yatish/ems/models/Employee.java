package com.yatish.ems.models;

import java.io.Serializable;

public abstract class Employee implements Serializable {

    protected static int count = 1;
    protected int id;
    protected String name;
    protected String city;
    protected String state;
    protected double baseSalary=15000;
    protected String role;

    public Employee(String name, String city, String state,String role) {
        this.id = count++;
        this.name = name;
        this.city = city;
        this.state = state;
        this.role = role;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }
    
    public static void setCount(int cnt) {
        count = cnt;
    }
    public String getName() { return name; }
    public String getState() { return state; }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return id + " | " + name + " | " + city + " | " + state + " | " + role + " | " + calculateSalary();
    }
}
