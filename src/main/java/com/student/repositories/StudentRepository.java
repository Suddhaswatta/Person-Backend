package com.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.domains.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
