package com.st.entities;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Empservice {

	@Autowired
	private EmpRepo empRepo;
	//create a employee
	public Employee saveEmployee(Employee employee) {
		String date = LocalDate.now().toString();    
//		Random random=new Random();
		int a=new Random().nextInt(100000);
		String s=date+"-"+a;
		System.out.println(s);
		Employee e=this.empRepo.save(employee);
		return e;
	}
}
