package com.yatish.service;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;

import com.yatish.dao.EmployeeDAO;
import com.yatish.dao.EmployeeDAOImpl;
import com.yatish.entity.EmployeeEntity;
import com.yatish.model.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    private ModelMapper modelMapper = new ModelMapper();
    private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

    @Override
    public Optional<EmployeeDTO> addEmployee(EmployeeDTO employeeDTO) {
        logger.info("Adding employee: {}", employeeDTO);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        System.out.println(employeeEntity);
        employeeDAO.addEmployee(employeeEntity);
        return Optional.empty();
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public Optional<List<EmployeeDTO>> getAllEmployees() {
        Optional<List<EmployeeEntity>> employeeEntities = employeeDAO.getAllEmployees();
        List<EmployeeDTO> dtoList = employeeEntities.get()
                .stream()
                .map(entity -> modelMapper.map(entity, EmployeeDTO.class))
                .toList();

        return Optional.of(dtoList);
    }

    @Override
    public Optional<List<EmployeeDTO>> getByCity(String city) {
        Optional<List<EmployeeEntity>> employeeEntities = employeeDAO.getByCity(city);
        List<EmployeeDTO> dtoList = employeeEntities.get()
                .stream()
                .map(entity -> modelMapper.map(entity, EmployeeDTO.class))
                .toList();

        return Optional.of(dtoList);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeDAO.deleteEmployeeById(id);
    }
}
