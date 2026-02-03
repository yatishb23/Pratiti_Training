package com.yatish.service;

import java.util.List;
import java.util.Optional;

import com.yatish.entity.EmployeeEntity;
import com.yatish.model.EmployeeDTO;

public interface EmployeeService {
    Optional<EmployeeDTO> addEmployee(EmployeeDTO employeeDTO);

    Optional<EmployeeEntity> getEmployeeById(int id);

    Optional<List<EmployeeDTO>> getAllEmployees();

    Optional<List<EmployeeDTO>> getByCity(String city);

    void deleteEmployeeById(int id);
}
