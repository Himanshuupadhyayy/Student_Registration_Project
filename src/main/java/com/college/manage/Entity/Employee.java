package com.college.manage.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	private int empId;
	
	private String empName;

//	@OneToOne(cascade = CascadeType.ALL)
//	private Project project;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "empId")
//	private List<Project> project;
	
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "emp_project", joinColumns = {@JoinColumn( name="eid")}, inverseJoinColumns = { @JoinColumn(name="pid")	})
//	private List<Project> projects;
}