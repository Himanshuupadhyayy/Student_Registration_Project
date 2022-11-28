package com.college.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.manage.Entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
