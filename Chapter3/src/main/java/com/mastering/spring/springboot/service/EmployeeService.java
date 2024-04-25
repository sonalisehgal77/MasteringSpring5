package com.mastering.spring.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mastering.spring.springboot.bean.Employee;

@Service
public class EmployeeService {
	private static List<Employee> employees = new ArrayList<Employee>();
	private static int employeeCount = 3;
	static {
		employees.add(new Employee(1, "Jack", "Learn Spring MVC", new Date(), false));
		employees.add(new Employee(2, "Jack", "Learn Struts", new Date(), false));
		employees.add(new Employee(3, "Jill", "Learn Hibernate", new Date(), false));
	}

	public List<Employee> retrieveEmployees(String user) {
		List<Employee> filteredEmployees = new ArrayList<Employee>();
		for (Employee employee : employees) {
			if (employee.getUser().equals(user))
				filteredEmployees.add(employee);
		}
		return filteredEmployees;
	}

	public Employee addEmployee(String name, String desc, Date targetDate, boolean isDone) {
		Employee employee = new Employee(++employeeCount, name, desc, targetDate, isDone);
		employees.add(employee);
		return employee;
	}

	public Employee retrieveEmployee(int id) {
		for (Employee employee : employees) {
			if (employee.getId() == id)
				return employee;
		}
		return null;
	}
}