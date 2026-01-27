package com.yatish.DAO;

import com.yatish.models.Employee;

public class EmployeeDAO {
	static Employee[] employees=new Employee[50];
	static int count=0;
	static {
		employees[0]=new Employee(1, "YATISH", "MUMBAI");
		count=1;
	}
	public EmployeeDAO() {
		
	}
	
	public Employee[] getEmployees() {
		return employees;
	}
	
	public boolean checkId(int id) {
		for(Employee e:employees) {
			if(e!=null && e.getId()==id) {
				return true;
			}
		}
		return false;
	}
	public void addEmployee(Employee[] data) {
		for(Employee e:data) {
			if(e==null) break;
			employees[count]=new Employee(e.getId(), e.getName().toUpperCase(), e.getCity().toUpperCase());
			count++;
		}
	}
	
	public void updateEmployeeName(int id, String name) {
		for(Employee e: employees) {
			if(e!=null && e.getId()==id) {
				e.setName(name.toUpperCase());
				break;
			}
		}
	}
	public void updateEmployeeCity(int id, String city) {
		for(Employee e: employees) {
			if(e!=null && e.getId()==id) {
				e.setCity(city.toUpperCase());
				break;
			}
		}
	}
	public void updateEmployee(int id,String name, String city) {
		for(Employee e: employees) {
			if(e!=null && e.getId()==id) {
				e.setCity(city.toUpperCase());
				e.setName(name.toUpperCase());
				break;
			}
		}
	}
}
