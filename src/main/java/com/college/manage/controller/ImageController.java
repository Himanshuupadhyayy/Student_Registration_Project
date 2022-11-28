package com.college.manage.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.college.manage.service.DocumentService;
import com.college.manage.Entity.*;
import com.college.manage.dto.*;
@RestController
public class ImageController {

	@Autowired
	private DocumentService service;
	
	
/*	@PostMapping("/upload-file")
	public Documents uploadDocumentsNumber(@RequestBody Documents doc) {
		this.service.saveDocument(doc);
		return doc;
	}
*/
	
	
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadImageToFIleSystem(
			@RequestParam String studentCourse,
			@RequestParam String studentLastQualification,
			@RequestParam String studentAdharNumber,
			@RequestParam("photo") MultipartFile studentPhoto,
			@RequestParam("adhar") MultipartFile studentAdhar) throws IOException {
		String uploadImage = null;
		if (!studentPhoto.isEmpty() && !studentAdhar.isEmpty() ) {
			uploadImage = this.service.uploadPhoto(studentCourse,studentLastQualification,studentAdharNumber, studentPhoto, studentAdhar);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no need to upload empty file");
		}
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}


	
}