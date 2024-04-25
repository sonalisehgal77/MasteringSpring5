package com.mastering.spring.springboot.controller;

import java.net.URI;
import java.util.List;

import com.mastering.spring.springboot.bean.Employee;
import com.mastering.spring.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/users/{name}/employee")
	public List<Employee> retrieveEmployees(@PathVariable String name) {
		return employeeService.retrieveEmployees(name);
	}

	@GetMapping(path = "/users/{name}/employees/{id}")
	public Employee retrieveEmployee(@PathVariable String name, @PathVariable int id) {
		return employeeService.retrieveEmployee(id);
	}

	@PostMapping("/users/{name}/employees")
	ResponseEntity<?> add(@PathVariable String name, @RequestBody Employee employee) {
		Employee createdEmployee = employeeService.addEmployee(name, employee.getDesc(), employee.getTargetDate(), employee.isDone());
		if (createdEmployee == null) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdEmployee.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}