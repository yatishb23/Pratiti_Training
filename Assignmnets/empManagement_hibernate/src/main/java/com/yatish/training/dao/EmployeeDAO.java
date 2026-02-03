/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.yatish.training.dao;

import java.util.List;
import java.util.Optional;

import com.yatish.training.models.EmployeeEntity;

interface EmployeeDAO {

    Optional<EmployeeEntity> addEmployee(EmployeeEntity e);
    boolean canUpdateEmployee(EmployeeEntity emp);
    void deleteEmployeeById(int id);
    Optional<List<EmployeeEntity>> getAllEmployees();
    Optional<EmployeeEntity> getEmployeeById(int id);
    Optional<List<EmployeeEntity>> getEmployeeByState(String state);
    Optional<List<EmployeeEntity>> getEmployeeByName(String name);
    boolean canChange(EmployeeEntity emp);
    boolean updateEmployee(EmployeeEntity emp);
}
