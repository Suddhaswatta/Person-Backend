package com.student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.domains.Student;
import com.student.services.StudentService;

@RestController
@RequestMapping("student/api/")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("/students")
	ResponseEntity<?> getAll() {

		Iterable<Student> students = service.getAll();
		return new ResponseEntity<>(students, HttpStatus.OK);

	}

	@GetMapping("/students/{id}")
	ResponseEntity<?> getById(@PathVariable String id) {

		Student student = service.getById(id);

		return new ResponseEntity<>(student, HttpStatus.OK);

	}

	@PostMapping("/students")
	ResponseEntity<?> save(@RequestBody Student student) {

		Student saved = service.save(student);

		return new ResponseEntity<>(saved, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<?> save(@PathVariable String id) {

		boolean yes = service.delete(id);

		return new ResponseEntity<>(yes, HttpStatus.NO_CONTENT);

	}

	@PostMapping("/filter")
	ResponseEntity<?> filter(@RequestBody Student student) {

		Iterable<Student> students = service.filter(student);
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

}
