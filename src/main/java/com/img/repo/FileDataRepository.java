package com.img.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.img.entities.FileData;

import java.sql.Blob;
import java.util.List;
import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData, Long> {

	public Optional<FileData> findById(Long id);
	
}