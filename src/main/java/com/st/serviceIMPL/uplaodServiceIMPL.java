package com.st.serviceIMPL;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.st.entities.Documents;
import com.st.repository.Document_Upload_Repository;
import com.st.services.uploadServices;

@Service
public class uplaodServiceIMPL implements uploadServices{

	@Autowired
	private Document_Upload_Repository repository;

	
	
	/*
	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    Documents doc = new Documents(fileName, file.getContentType(), file.getBytes());
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
	    String filePath=path+ File.separator+fileName;	
	    Files.copy(file.getInputStream(), Paths.get(filePath));
	    repository.save(doc);
	    return "done";
	}
*/



	@Override
	public String uploadImage(String path, MultipartFile St_photo, MultipartFile st_aadhar_card,
			MultipartFile st_SSC_Certificate, MultipartFile st_HSC_Certificate) throws IOException {
		String fileName = StringUtils.cleanPath(St_photo.getOriginalFilename());
		String fileName1 = StringUtils.cleanPath(st_aadhar_card.getOriginalFilename());
		String fileName2 = StringUtils.cleanPath(st_SSC_Certificate.getOriginalFilename());
		String fileName3 = StringUtils.cleanPath(st_HSC_Certificate.getOriginalFilename());
		
		String filePath=path+ File.separator+fileName;
		String filePath1=path+ File.separator+fileName1;
		String filePath2=path+ File.separator+fileName2;
		String filePath3=path+ File.separator+fileName3;
		System.out.println(filePath);
		Files.copy(St_photo.getInputStream(), Paths.get(filePath));
		Files.copy(st_aadhar_card.getInputStream(), Paths.get(filePath1));
		Files.copy(st_SSC_Certificate.getInputStream(), Paths.get(filePath2));
		Files.copy(st_HSC_Certificate.getInputStream(), Paths.get(filePath3));
		Documents doccc=new Documents(fileName, St_photo.getContentType(), St_photo.getBytes(), st_aadhar_card.getBytes(), st_HSC_Certificate.getBytes(), st_SSC_Certificate.getBytes());
		repository.save(doccc);
		return "done";
	}
	
	
	/*
	public String uploadImage(String path, MultipartFile file) throws IOException {
		//file name
		String name=file.getOriginalFilename();
		
		//random name generate of file 
		String randomID=UUID.randomUUID().toString();
		String fileName1=randomID.concat(name.substring(name.lastIndexOf(".")));
		//full file path
		String filePath=path+ File.separator+fileName1;
		
		//create folder if not create
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		//file copy and upload file
		Files.copy(file.getInputStream(), Paths.get(filePath));
		this.repository.save(file.getInputStream(), Paths.get(filePath));
		return name;
	}
	*/

}