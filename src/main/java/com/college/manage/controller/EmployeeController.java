package com.college.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.manage.Entity.Employee;
import com.college.manage.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee emp) {
		return this.employeeService.saveEmployee(emp); 
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		List<Employee> list=(List<Employee>) this.employeeService.getAllBooks(); 
		return list;
	}	
}