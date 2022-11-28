package com.college.manage.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_details")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentId;
	private String studentName;
	private String studentFatherName;
	private String studentMotherName;
	
	//DateTimeFormat
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date student_DateOfBirth;
	
	
	
	private String studentAddress;
	private String studentCity;
	private String studentState;
	private String studentPinCode;
	private String gender;
	private String studentPhone;
	private String studentEmail;

	@OneToOne(cascade = CascadeType.ALL)
	private Documents documents;
	@CreationTimestamp
	private LocalDateTime regDateTime;

}