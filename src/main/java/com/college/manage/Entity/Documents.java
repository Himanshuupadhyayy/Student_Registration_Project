package com.college.manage.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Documents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "document_Id")
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
	
	@OneToOne(mappedBy = "documents")
	private Student student;
}