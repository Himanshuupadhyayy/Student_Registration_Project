package com.college.manage.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

	@Id
	private int projectId;
	private String projectName;
	
//	@OneToOne(mappedBy = "project")
//	@JsonIgnore
//	private Employee employee;
	
	
//	@ManyToOne
//	@JoinColumn(name = "empId")
//	private Employee employees;
	
//	@ManyToMany(mappedBy = "projects")
//	private List<Employee> employees;
	
}