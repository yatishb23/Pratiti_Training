package com.yatish.service;

import com.yatish.DAO.EmployeeDAO;
import com.yatish.models.Employee;

public class EmployeeService {
	static EmployeeDAO dao=new EmployeeDAO();

 	public EmployeeService() {
 		
	}
 	
	public void addEmployeeService(Employee[] employee) {
		dao.addEmployee(employee);
	}
	
	public void viewEmployees() {
		Employee[] employees=dao.getEmployees();
		System.out.println();
		for(Employee e:employees) {
			if(e!=null)
			System.out.println(e.getId()+" "+e.getName()+" "+e.getCity());
		}
		System.out.println();
	}
	
	public boolean verifyId(int id) {
		return dao.checkId(id);
	}
	public void updateName(int id,String name) {
		dao.updateEmployeeName(id,name);
	}
	public void updateCity(int id,String city) {
		dao.updateEmployeeCity(id,city);
	}
	public void updateBoth(int id,String name,String city) {
		dao.updateEmployee(id, name, city);
	}
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}
}
