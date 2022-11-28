package com.college.manage.dto;

import java.util.Date;
import com.college.manage.Entity.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {

	private int studentId;
	private String studentName;
	private String studentFatherName;
	private String studentMotherName;
	private Date student_DateOfBirth;
	
	
	
	private String studentAddress;
	private String studentCity;
	private String studentState;
	private String studentPinCode;
	private String gender;
	private String studentPhone;
	private String studentEmail;
	private Documents documents;
	
}
