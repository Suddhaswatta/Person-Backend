package com.student.services;


import java.util.Map;

import org.springframework.stereotype.Service;

import com.student.domains.Student;
import com.student.models.FilterRequest;

@Service
public interface StudentService {
	
	Iterable <Student> getAll();
	
	Student getById(String id);
	
	Student save(Student student);
	
	boolean delete(String id);
	
	Iterable<Student> filter(FilterRequest filterRequest);
	
	Map options();
	

}
