package com.student.domains;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

	@Id
	String id;
	String studentno;
	@NonNull
	String firstname;
	@NonNull
	String lastname;
	@NonNull
	Date dob;
	@NonNull
	String age;

}
