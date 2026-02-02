/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.yatish.dao;

import java.util.Optional;

import com.yatish.entity.EmployeeEntity;

/**
 *
 * @author yatis
 */
public interface EmployeeDAO {

    Optional<EmployeeEntity> addEmployee(EmployeeEntity ee);

    Optional<EmployeeEntity> getEmployeeById(Integer empId);

}
