package com.img.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.img.entities.FileData;
import com.img.repo.FileDataRepository;
import com.img.service.StorageService;

@RestController
public class ImageController {

	
	@Autowired
	private StorageService service;

	@Autowired
	private FileDataRepository repo;
	
	@PostMapping("/upload-file")
	public ResponseEntity<?> uploadImageToFIleSystem(
			@RequestParam("photo")MultipartFile Stphoto,
			@RequestParam("adhar")MultipartFile Stadhar,
			@RequestParam("HSC")MultipartFile Sthsc,
			@RequestParam("SSC")MultipartFile Stssc
			) throws IOException {
		String uploadImage=null;
		if(!Stphoto.isEmpty() && !Stadhar.isEmpty() && !Sthsc.isEmpty() && !Stssc.isEmpty()) {
			 uploadImage = this.service.uploadImageToFileSystem(Stphoto, Stadhar, Sthsc, Stssc);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no need to upload empty file");
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}



	@GetMapping("image/{id}")
	public ResponseEntity<byte[]> fromDatabaseAsResEntity(@PathVariable("id") long id) 
	        throws SQLException, IOException {

		Optional<FileData> data = repo.findById(id);
		String imageBytes = null;
		byte[] images=null;
		if (data.isPresent()) {
			imageBytes = data.get().getSt_photo_filePath();
			System.out.println(imageBytes);
			images	= Files.readAllBytes(new File(imageBytes).toPath());
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(images);
	}
	
	@DeleteMapping("/image/{id}")
	public void deleteStPhotoFromDB(@PathVariable Long id){
		this.repo.deleteById(id);
	}
	
	
	@PutMapping("/image/{id}")
	public ResponseEntity<?> updateImageIntoDB(@PathVariable long id,
			@RequestParam("photo")MultipartFile Stphoto) throws IOException{
		Optional<FileData> data = repo.findById(id);
		String imageBytes = data.get().getSt_photo_filePath();
		if(!Stphoto.isEmpty()) {
			//delete the photo
	//		this.repo.deleteById(id);
			//update the photo
			this.service.UpdatePhoto(Stphoto, id);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("new upload file is empty");
		}
		return ResponseEntity.status(HttpStatus.OK).body("new image is uplaoded !!");
	}
	
	
	
}