package com.st.serviceIMPL;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.st.entities.Student;
import com.st.repository.StudentRepository;
import com.st.services.StudentService;

@Service
public class StudentServiceIMPL implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student createStudent(Student student) {
		Student student1=this.studentRepository.save(student);
		return student1;
	}
	

}