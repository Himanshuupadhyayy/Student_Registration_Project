package com.college.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.manage.Entity.Employee;
import com.college.manage.repository.EmpRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmpRepository empRepository;
	
	public Employee saveEmployee(Employee emp) {
		return this.empRepository.save(emp);
	}
	
	
	public List<Employee> getAllBooks(){
		List<Employee> list =(List<Employee>)this.empRepository.findAll();
		return list;
	}
}
