package com.student.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	String id;
	String studentno;
	String firstname;
	String lastname;
	String age;


}
