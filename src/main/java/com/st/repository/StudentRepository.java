package com.st.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}