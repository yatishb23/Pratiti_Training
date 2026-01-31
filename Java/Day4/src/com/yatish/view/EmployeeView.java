package com.yatish.view;

import java.util.Scanner;

import com.yatish.models.Employee;
import com.yatish.service.*;

public class EmployeeView {
	Scanner sc=new Scanner(System.in);
	static EmployeeService service=new EmployeeService();
	
	public EmployeeView() {
		employeeOptions();
	}
	
	private void employeeOptions() {
			System.out.println("==== Employee Qptions ====");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.println("Enter choice..... ");
			int choice=sc.nextInt();
			selectedOption(choice);
	}
	
	private void selectedOption(int choice) {
		switch (choice) {
		case 1: {
			addEmployee();
			employeeOptions();
			break;
		}
		case 2:
			viewEmployees();
			employeeOptions();
			break;
		case 3:
			updateEmployee();
			employeeOptions();
		case 4:
			deleteEmployee();
			employeeOptions();
		case 5:
			exitEmployee();
			break;
		default:
			
			break;
		}
	}
	
	private void deleteEmployee() {
		while(true) {
			System.out.println("Enter employee ID: ");
			int id=sc.nextInt();
			
			if(service.verifyId(id)) {
				service.deleteEmployee(id);
				break;
			}
			System.out.println("Invalid ID please try again...");
		}
	}

	private void updateEmployee() {
		while(true) {
			System.out.println("Enter employee ID: ");
			int id=sc.nextInt();
			
			if(service.verifyId(id)) {
				System.out.println("What you want to update: \n"
						+ "1. name \n"
						+ "2. city \n"
						+ "3. both ");
				int update=sc.nextInt();
				switch (update) {
				case 1: {
					System.out.println("Enter new name: ");
					String name=sc.next();
					service.updateName(id,name);
					break;
				}
				case 2:{
					System.out.println("Enter new city: ");
					String city=sc.next();
					service.updateCity(id,city);
					break;
				}
				case 3:{
					System.out.println("Enter new name: ");
					String name=sc.next();
					System.out.println("Enter new city: ");
					String city=sc.next();
					service.updateBoth(id,name,city);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + update);
				}
				break;
			}
			System.out.println("Invalid ID please try again...");
		}
	}

	private void exitEmployee() {
		sc.close();
		System.exit(0);
	}
	
	private void addEmployee() {
		String c="n";
		Employee[] employees=new Employee[10];
		int cnt=0;
		do {
			
			int empid=-1;
			while(true) {
				
				System.out.println("Enter Employee Id: ");
				int id = sc.nextInt();
				sc.nextLine();
				
				if(service.verifyId(id)) {
					System.out.println("ID already exists");
				}else {
					empid=id;
					break;
				}
			}
			
			
			System.out.println("Enter Employee Name: ");
			String name=sc.next();
			sc.nextLine();
			System.out.println("Enter Employee City: ");
			String city=sc.next();
			sc.nextLine();
			
			employees[cnt]=new Employee(empid, name, city);
			cnt++;
			
			System.out.println("Do you want to add more Employee : Y/N");
			c=sc.next();
			
		}while(c.equalsIgnoreCase("Y"));
		
		service.addEmployeeService(employees);
	}
	
	private void viewEmployees() {
		service.viewEmployees();
	}
}


