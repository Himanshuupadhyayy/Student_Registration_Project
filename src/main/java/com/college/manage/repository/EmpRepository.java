package com.college.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.manage.Entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
