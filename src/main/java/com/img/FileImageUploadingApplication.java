package com.img;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileImageUploadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileImageUploadingApplication.class, args);	
		System.out.println("image processing");
	}
}