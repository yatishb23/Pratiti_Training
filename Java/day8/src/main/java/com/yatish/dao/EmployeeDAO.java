package com.yatish.dao;

import java.util.List;
import java.util.Optional;

import com.yatish.model.EmployeeEntity;

public interface EmployeeDAO {
    public void addEmployee(EmployeeEntity employee);
    public Optional<List<EmployeeEntity>> showEmployee();
    public Optional<EmployeeEntity> getEmployeeById(Integer empId);
}
