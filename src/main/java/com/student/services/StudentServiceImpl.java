package com.student.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.domains.Student;
import com.student.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repo;
	
	@Override
	public Iterable<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student save(Student person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Student> filter(String id, String firstname, String lastname, String age, Date dob) {
		// TODO Auto-generated method stub
		return null;
	}

}
