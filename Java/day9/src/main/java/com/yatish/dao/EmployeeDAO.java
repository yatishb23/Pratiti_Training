package com.yatish.dao;

import java.util.List;
import java.util.Optional;

import com.yatish.entity.EmployeeEntity;

public interface EmployeeDAO {

    Optional<EmployeeEntity> addEmployee(EmployeeEntity employeeEntity);

    Optional<EmployeeEntity> getEmployeeById(int id);

    Optional<List<EmployeeEntity>> getAllEmployees();

    Optional<List<EmployeeEntity>> getByCity(String city);

    void deleteEmployeeById(int id);

}
