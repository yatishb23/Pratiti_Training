package com.yatish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.yatish.JDBC.GetConnection;
import com.yatish.model.EmployeeEntity;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final Connection connection = GetConnection.getConneciton();

    @Override
    public void addEmployee(EmployeeEntity employeeEntity) {
        String sql = "INSERT INTO employee VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, employeeEntity.getEmpId());
            pstmt.setString(2, employeeEntity.getEmpName());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<List<EmployeeEntity>> showEmployee(){
        String sql="Select * from employee;";
        List<EmployeeEntity> list=new ArrayList<>();
        try (PreparedStatement pstmt =connection.prepareStatement(sql)){
            ResultSet rs=pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                list.add(new EmployeeEntity(rs.getInt("empid"),rs.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(list);
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeById(Integer empId){
        String sql = "select * from employee where empid="+empId;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs=pstmt.executeQuery();
            
            if (rs.next()) {
                EmployeeEntity employee = new EmployeeEntity(rs.getInt("empId"),rs.getString("Name"));
                return Optional.of(employee);
            }
            System.out.println("Employee does not exist....");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
