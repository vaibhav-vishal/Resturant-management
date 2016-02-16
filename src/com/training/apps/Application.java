package com.training.apps;

import com.training.daos.EmployeeDAO;
import com.training.entity.Employee;
import com.training.entity.ValidateEmployee;

public class Application {

	public static void main(String[] args) {
//		try {
//			Employee emp = new Employee(101, "Suresh", 8867819222L, "Chef");
//			EmployeeDAO dao = new EmployeeDAO();
//			int rowadded = dao.add(emp);
//			System.out.println(rowadded + " Row Added");
//		} catch (Exception e) {
//			System.out.println("Invalid input" + e);
//		}
		Employee emp1 = new Employee("Suresh", "Suresh123");
		ValidateEmployee val = new ValidateEmployee();
		System.out.println(val.validate(emp1));
		Employee emp2 = new Employee("Suresh", "suresh");
		System.out.println(val.validate(emp2));

	}

}
