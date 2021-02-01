package com.student.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomEntityExceptionHandler {
	
	@ExceptionHandler
	public final ResponseEntity<?> studentNotFoundExceptionHandler(StudentNotFoundException ex,WebRequest req){
		
		HashMap<String,String> response = new HashMap<String, String>();
		response.put("error", ex.getMessage());
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}

}
