package com.college.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.manage.Entity.Student;
import com.college.manage.dto.StudentDto;
import com.college.manage.service.StudentService;

@RestController
@RequestMapping("/st")
public class StudentController {

	@Autowired
	private StudentService service;

//post the student data
	@PostMapping("/student")
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
		StudentDto createStudentDto = this.service.createStudent(studentDto);
		return new ResponseEntity<StudentDto>(createStudentDto, HttpStatus.CREATED);
	}
	
//get student by id	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
	return 	this.service.getStudent(studentId);
	}
	
//delete the student details by id	
		@DeleteMapping("/student/{studentId}")
		public void deleteStudent(@PathVariable int studentId) {
			 this.service.deleteStudent(studentId);
		}
		
//update the student Details
		@PutMapping("/student/{studentId}")
		public ResponseEntity<Student> updateStudent(@RequestBody Student student, 
				@PathVariable int studentId){
			Student save=this.service.updateStudent(student, studentId);
			return ResponseEntity.ok(save);
		}
}	