package com.student.services;


import org.springframework.stereotype.Service;

import com.student.domains.Student;

@Service
public interface StudentService {
	
	Iterable <Student> getAll();
	
	Student getById(String id);
	
	Student save(Student student);
	
	boolean delete(String id);
	
	Iterable<Student> filter(Student student);
	

}
