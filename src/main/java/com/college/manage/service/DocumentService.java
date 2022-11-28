package com.college.manage.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.college.manage.Entity.Documents;
import com.college.manage.repository.*;

@Service
public class DocumentService {

	@Autowired
	private DocumentsRepository documentsRepository;

	private String FOLDER_PATH="C:\\Users\\Development\\All_Photos\\";
	
	// upload some documents like aadhar card and photo of student
	public String uploadPhoto(String studentCourse,String studentLastQualification, String studentAdharNumber, MultipartFile studentPhoto, MultipartFile studentAdhar)
			throws IOException {
		// get the fullly path of all files
		String student_Photo_FilePath = FOLDER_PATH + studentPhoto.getOriginalFilename();
		String student_Adhar_FilePath = FOLDER_PATH + studentAdhar.getOriginalFilename();

		// will check the file type is it jpg or pdf
		String photoFileType = studentPhoto.getContentType();
		String adharFleType = studentAdhar.getContentType();

		if (photoFileType.equals("image/png") || photoFileType.equals("image/jpeg")) {
			if (adharFleType.equals("application/pdf")) {

				// save the file into db
				Documents documents = documentsRepository.save(Documents.builder()
						
						.studentAdharNumber(studentAdharNumber)
						.studentCourse(studentCourse)
						.studentLastQualification(studentLastQualification)

						// save the student photo
						.student_Photo_FileName(studentPhoto.getOriginalFilename())
						.student_Photo_FileType(photoFileType)
						.student_Photo_FilePath(student_Photo_FilePath)
						// save the student aadhar card
						.student_Adhar_FileName(studentAdhar.getOriginalFilename())
						.student_Adhar_FilePath(student_Adhar_FilePath)
						.student_Adhar_FileType(adharFleType).build());

				// take file from source path and paste it to the destination path
				studentPhoto.transferTo(new File(student_Photo_FilePath));
				studentAdhar.transferTo(new File(student_Adhar_FilePath));
				if (documents != null) {
					return "file uploaded successfully : ";
				}
			}
		} else {
			return "image in jpg or png formate";
		}
		return "photo and aadhar file is uploaded";
	}


}