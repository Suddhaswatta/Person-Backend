package com.student.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.domains.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
	
	@Query("SELECT DISTINCT s.age FROM Student s")
	List ageOptions();
	
	@Query("SELECT DISTINCT s.standard FROM Student s")
	List standardOptions();
	
	@Query("SELECT DISTINCT s.section FROM Student s")
	List sectionOptions();
	
	
	
}
