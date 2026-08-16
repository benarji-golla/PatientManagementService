package com.patientmngservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class GlobalExceptionHandler {


	@ExceptionHandler(PatientDetailsException.class)
	public ResponseEntity<String> PatientDetailsException(PatientDetailsException exception ){
		
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<String> PatientNotFoundException(PatientNotFoundException exception){
		
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
}
