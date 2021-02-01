package com.student;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.domains.Student;
import com.student.services.StudentService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentApplication implements CommandLineRunner{

	@Autowired
	StudentService service;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	


	@Override
	public void run(String... args) throws Exception {
		Student student = new Student("Bill","Gates",new Date(),"17","11","B");
		service.save(student);
		Student student1 = new Student("Dan","Lok",new Date(),"16","10","C");
		service.save(student1);
		Student student2 = new Student("Stephen","Hawken",new Date(),"16","11","A");
		service.save(student2);
		Student student3 = new Student("Baba","Rajnesh",new Date(),"18","10","A");
		service.save(student3);
		Student student4 = new Student("Wolf","Gupta",new Date(),"19","12","C");
		service.save(student4);
		Student student5 = new Student("Stephen","Chow",new Date(),"19","12","D");
		service.save(student5);
		Student student6 = new Student("Captain.","Blackadder",new Date(),"25","11","B");
		service.save(student6);
		
		
		
		
	}

}
