package com.st.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String St_RegNo;
	private String St_name;
	private String fatherName;
	private String motherName;
	private String St_dateOfBirth;
	private String St_address;
	private String St_city;
	private String St_state;
	private String St_pinCode;
	private String Gender;
	private String St_phone;
	private String St_Email;
	private String St_course;
	private String St_aadharNumber;
	private String LastQualification;
	@CreationTimestamp
//	@Column(name = "create_At", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime Reg_Date_Time;

}