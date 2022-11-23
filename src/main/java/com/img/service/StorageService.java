package com.img.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.img.entities.FileData;
import com.img.repo.FileDataRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class StorageService {

	@Autowired
	private FileDataRepository fileDataRepository;

	private final String FOLDER_PATH = "C:\\Users\\Development\\All_Photos\\";

	
	//upload image and all documents (10th, 12th, aadhar card) etc.
	public String uploadImageToFileSystem(MultipartFile Stphoto, MultipartFile Stadhar, MultipartFile Stssc,
			MultipartFile Sthsc) throws IOException {
		
		//get the fullly path of all files
		String Stphoto_filePath = FOLDER_PATH + Stphoto.getOriginalFilename();
		String Stadhar_filePath = FOLDER_PATH + Stadhar.getOriginalFilename();
		String Stssc_filePath = FOLDER_PATH + Stssc.getOriginalFilename();
		String Sthsc_filePath = FOLDER_PATH + Sthsc.getOriginalFilename();

		//will check the file type is it jpg or pdf
		String type = Stphoto.getContentType();
		String type_adhar = Stadhar.getContentType();
		String type_ssc = Stssc.getContentType();
		String type_hsc = Sthsc.getContentType();

		System.out.println(type);
		if (type.equals("image/png") || type.equals("image/jpeg")) {
			if (type_adhar.equals("application/pdf") && type_ssc.equals("application/pdf")
					&& type_hsc.equals("application/pdf")) {

				//save the file into db
				FileData fileData = fileDataRepository.save(FileData.builder()
						
						//save the student photo
						.St_photo_name(Stphoto.getOriginalFilename())
						.St_photo_type(Stphoto.getContentType())
						.St_photo_filePath(Stphoto_filePath)
						
						
						//save the student aadhar card
						.St_adhar_name(Stadhar.getOriginalFilename())
						.St_adhar_type(Stadhar.getContentType())
						.St_adhar_filePath(Stadhar_filePath)
						
						//save the student HSC certificate
						.St_hsc_name(Sthsc.getOriginalFilename())
						.St_hsc_type(Sthsc.getContentType())
						.St_hsc_filePath(Sthsc_filePath)
						
						//save the student SSC certificate
						.St_ssc_name(Stssc.getOriginalFilename())
						.St_ssc_type(Stssc.getContentType())
						.St_ssc_filePath(Stssc_filePath).build());
				
				//take file from source path and paste it to the destination path
				Stphoto.transferTo(new File(Stphoto_filePath));
				Stadhar.transferTo(new File(Stadhar_filePath));
				Sthsc.transferTo(new File(Sthsc_filePath));
				Stssc.transferTo(new File(Stssc_filePath));
				if (fileData != null) {
					return "file uploaded successfully : "; // + filePath
				}
			}
		} else {
			return  "image in jpg or png formate";
		}
		return "please upload file all documents in pdf file formate ";
	}

	
	
	//update a single photo
	public String UpdatePhoto(MultipartFile Stphoto, Long id) throws IOException {
		FileData file=new  FileData();
		file.setId(id);
		//get the fullly path of all files
		String Stphoto_filePath = FOLDER_PATH + Stphoto.getOriginalFilename();

		//will check the file type is it jpg or pdf
		String type = Stphoto.getContentType();

		System.out.println(type);
		if (type.equals("image/png") || type.equals("image/jpeg")) {

				//save the file into db
				FileData fileData = fileDataRepository.save(FileData.builder()
						.id(id)
						//save the student photo
						.St_photo_name(Stphoto.getOriginalFilename())
						.St_photo_type(Stphoto.getContentType())
						.St_photo_filePath(Stphoto_filePath).build());
				
				//take file from source path and paste it to the destination path
				Stphoto.transferTo(new File(Stphoto_filePath));
				if (fileData != null) {
					return "file uploaded successfully : "; // + filePath
				}
			} else {
			return  "image in jpg or png formate";
		}
		return "ok uploaded new photo";
	}
	
}