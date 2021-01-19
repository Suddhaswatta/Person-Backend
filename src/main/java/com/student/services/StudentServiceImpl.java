package com.student.services;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.domains.Student;
import com.student.exception.StudentNotFoundException;
import com.student.repositories.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repo;

	@PersistenceContext
	EntityManager em;

	@Override
	public Iterable<Student> getAll() {

		Iterable<Student> students = repo.findAll();
		return students;
	}

	@Override
	public Student getById(String id) {

		Student student = repo.findById(id).orElse(null);
		if (student == null) {
			throw new StudentNotFoundException("Student with ID:" + id + " is not present");
		}
		return student;
	}

	@Override
	public Student save(Student student) {

		if (student.getId() == null || (student.getId() != null && student.getId().trim().isEmpty())) {
			String generatedId = generateStudentNumber();
			student.setStudentno(generatedId);
		} else {
			student.setStudentno(student.getId().substring(2));
		}

		String id = student.getFirstname().substring(0, 1).toLowerCase()
				+ student.getLastname().substring(0, 1).toLowerCase() + student.getStudentno();

		student.setId(id);

		Student saved = repo.save(student);
		return saved;
	}

	@Override
	public boolean delete(String id) {

		Student student = getById(id);
		repo.delete(student);

		return true;
	}

	@Override
	public Iterable<Student> filter(Student student) {

		return null;
	}

	private String generateStudentNumber() {

		Random rdn = new Random();
		String studentno = "";

		int n = 6;

		while (n > 0) {
			studentno = studentno + rdn.nextInt(9);
			n--;
		}

		return studentno;

	}

}
