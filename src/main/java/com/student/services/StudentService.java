package com.student.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.student.domains.Student;

@Service
public interface StudentService {
	
	Iterable <Student> getAll();
	
	Student getById(String id);
	
	Student save(Student person);
	
	boolean delete(String id);
	
	Iterable<Student> filter(String id,String firstname,String lastname,String age,Date dob);
	

}
