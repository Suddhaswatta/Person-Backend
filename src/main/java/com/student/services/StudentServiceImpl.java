package com.student.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.domains.Student;
import com.student.exception.StudentNotFoundException;
import com.student.models.FilterRequest;
import com.student.repositories.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repo;

	@PersistenceContext
	EntityManager em;
	
	Logger logger = org.slf4j.LoggerFactory.getLogger("StudentServiceImpl.class");

	@Override
	public Iterable<Student> getAll() {

		Iterable<Student> students = repo.findAll();
		return students;
	}

	@Override
	public Student getById(String id) {

		Student student = repo.findById(id).orElse(null);
		if (student == null) {
			throw new StudentNotFoundException("Student with ID: " + id + " is not present");
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
	public Iterable<Student> filter(FilterRequest filterRequest) {


		StringBuffer query = new StringBuffer();
		query.append("FROM Student as s ");
		query.append("WHERE ");
		String whereClause = "";
		
		if (filterRequest.getAge() != null && (!filterRequest.getAge().isEmpty() && filterRequest.getAge() != "undefined")) {
			whereClause += " s.age LIKE '" + filterRequest.getAge() + "' AND";
		}
		if (filterRequest.getSection() != null
				&& (!filterRequest.getSection().isEmpty() && filterRequest.getSection() != "undefined")) {
			whereClause += " s.section LIKE '" + filterRequest.getSection() + "' AND";
		}
		if (filterRequest.getStandard() != null
				&& (!filterRequest.getStandard().isEmpty() && filterRequest.getStandard() != "undefined")) {
			whereClause += " s.standard LIKE '" + filterRequest.getStandard() + "' AND";
		}
		
		query.append(whereClause.substring(0, whereClause.length() - 3));
		List students = em.createQuery(query.toString()).getResultList();
		logger.info(query.toString()+" Result Set :"+ students);
		return students;
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

	@Override
	public Map options() {
		
		HashMap<String, List> map = new HashMap<>();
		map.put("ageOptions", repo.ageOptions());
		map.put("sectionOptions", repo.sectionOptions());
		map.put("standardOptions", repo.standardOptions());

		return map;
	}

}
