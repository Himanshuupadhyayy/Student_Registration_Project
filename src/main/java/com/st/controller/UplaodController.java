package com.st.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.st.entities.Documents;
import com.st.services.uploadServices;

@RestController
public class UplaodController {
	
	@Autowired
	private uploadServices services;

	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(
			@RequestParam("photo") MultipartFile St_photo,
			@RequestParam("adhar") MultipartFile St_aadhar_card,
			@RequestParam("ssc") MultipartFile St_SSC_Certificate,
			@RequestParam("hsc") MultipartFile St_HSC_Certificate
			){
		
		String fileName=null;
		try {
			if(St_aadhar_card.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			if(!St_aadhar_card.getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
			}
			fileName=this.services.uploadImage(path, St_photo, St_aadhar_card, St_SSC_Certificate, St_HSC_Certificate);			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(new FileResponse(fileName, "somethink went wrong !!"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new FileResponse(fileName, "image is successfully uploaded"), HttpStatus.OK);
	}
}