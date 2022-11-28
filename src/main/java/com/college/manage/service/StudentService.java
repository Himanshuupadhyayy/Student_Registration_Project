package com.college.manage.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.manage.Entity.Student;
import com.college.manage.dto.StudentDto;
import com.college.manage.repository.*;

@Service
public class StudentService {


	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper mapper;

	public StudentDto createStudent(StudentDto studentDto) {
		Student student=this.dtoToStudent(studentDto);
		Student saveStudent=this.studentRepository.save(student);
		return this.studentToDto(saveStudent);
	}
	
	public Student getStudent(int studentId) {
		Student student=this.studentRepository.findById(studentId);
		return student;
	}
	
	public void deleteStudent(int studentId) {
		this.studentRepository.deleteById(studentId);	
	}
	
	public Student updateStudent(Student student, int studentId) {
		student.setStudentId(studentId);
		Student savedStudent=this.studentRepository.save(student);
		return savedStudent;
	}
	public Student dtoToStudent(StudentDto studentDto) {
		Student student=this.mapper.map(studentDto, Student.class);
		return student;
	}

	public StudentDto studentToDto(Student student) {
		StudentDto studentDto=this.mapper.map(student, StudentDto.class);
		return studentDto;
	}

}