package com.patientmngservice.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class GlobalExceptionHandler {


	@ExceptionHandler(PatientDetailsException.class)
	public ResponseEntity<String> PatientDetailsException(PatientDetailsException exception ){
		
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * @ExceptionHandler(PatientNotFoundException.class) public
	 * ResponseEntity<String> PatientNotFoundException(PatientNotFoundException
	 * exception){
	 * 
	 * return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND); }
	 */
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ProblemDetail PatientNotFoundException(PatientNotFoundException exception) {
		ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

		problem.setTitle("Patient Not Found");
		problem.setDetail(exception.getMessage());
		problem.setProperty("errorCode", "DOC_404");
		problem.setProperty("time stamp", Instant.now());
		problem.setProperty("service", "DoctorService");
		
		return problem;
	}
}
