package com.college.manage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.manage.Entity.Documents;

public interface DocumentsRepository extends JpaRepository<Documents, Integer>{

	public Optional<Documents> findById(int id);

}
