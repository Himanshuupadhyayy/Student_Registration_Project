	package com.st.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.entities.Student;
import com.st.services.StudentService;

@RestController
@RequestMapping("/st")
public class StudentController {
	
	@Autowired
	private StudentService service;

	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
	Student student1	=this.service.createStudent(student);
		return new ResponseEntity<Student>(student1, HttpStatus.CREATED);
	}
	
		
}