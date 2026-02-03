package com.yatish.training.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("MANAGER")
public class Manager extends EmployeeEntity {

    // REQUIRED by Hibernate
    public Manager() {}

    public Manager(String name, String city, String state, String manager) {
        super(name, city, state, "MANAGER");
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 2;
    }
}
