package com.yatish.training.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("DEVELOPER")
public class Developer extends EmployeeEntity {

    public Developer() {}

    public Developer(String name, String city, String state, String developer) {
        super(name, city, state, "DEVELOPER");
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 1.5;
    }
}
