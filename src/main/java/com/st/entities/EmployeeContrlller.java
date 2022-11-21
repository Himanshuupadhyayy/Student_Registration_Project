package com.st.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeContrlller {

	@Autowired
	private Empservice empservice;
	
	@PostMapping("/emp")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee e=this.empservice.saveEmployee(employee);
		return e;
	}
}
