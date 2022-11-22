package com.st.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.st.entities.Documents;


public interface uploadServices {

	public String uploadImage(String path, MultipartFile St_photo, MultipartFile st_aadhar_card, 
			MultipartFile st_SSC_Certificate, MultipartFile st_HSC_Certificate ) throws IOException;
}
