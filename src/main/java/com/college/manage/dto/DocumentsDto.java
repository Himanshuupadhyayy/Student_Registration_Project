package com.college.manage.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentsDto {

	private int documentId;

	
	private String studentCourse;
	private String studentLastQualification;
	private String studentAdharNumber;
	private String student_PanCard_Number;
	private String student_HighSchool_RollNo;
	private String student_InterMediate_RollNo;

	
	private String student_Photo_FileName;	
	private String student_Photo_FileType;
	private String student_Photo_FilePath;

	private String student_Adhar_FileName;
	private String student_Adhar_FileType;
	private String student_Adhar_FilePath;

	private String student_HighSchool_FileName;
	private String student_HighSchool_FileType;
	private String student_HighSchool_FilePath;

	private String student_InterMediate_FileName;
	private String student_InterMediate_FileType;
	private String student_InterMediate_FilePath;
}