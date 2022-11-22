package com.st.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.st.entities.Documents;

public interface Document_Upload_Repository extends JpaRepository<Documents, Long>{


}