package com.college.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.manage.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Student findById(int studentId);
}