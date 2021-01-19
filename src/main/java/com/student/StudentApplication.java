package com.student;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.student.domains.Student;
import com.student.services.StudentService;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentApplication implements CommandLineRunner{

	@Autowired
	StudentService service;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.student")).build();
	   }

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student("Suddhaswatta","Maity",new Date(),"25");
		service.save(student);
		Student student1 = new Student("Souraj","Maity",new Date(),"25");
		service.save(student1);
		Student student2 = new Student("Adam","Hawken",new Date(),"25");
		service.save(student2);
		Student student3 = new Student("Ram","Sam",new Date(),"25");
		service.save(student3);
		Student student4 = new Student("Wolf","Gupta",new Date(),"25");
		service.save(student4);
		Student student5 = new Student("Ganesh","Maity",new Date(),"25");
		service.save(student5);
		Student student6 = new Student("Gitasree","Maity",new Date(),"25");
		service.save(student6);
		
		
		
		
	}

}
