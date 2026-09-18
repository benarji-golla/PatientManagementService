package com.patientmngservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientmngservice.dto.PatientDetailsDto;
import com.patientmngservice.dto.RegisterPatientDto;
import com.patientmngservice.service.PatientDetailsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Component
@RestController
@RequestMapping("/Patient")
@RequiredArgsConstructor
public class PatientDetatilsController {

	private final PatientDetailsService patientDetailsService;
	
	@PostMapping("/register")
	public ResponseEntity<PatientDetailsDto> registerPatient(@Valid @RequestBody RegisterPatientDto regPatient) {
		PatientDetailsDto patientDetailsDto = patientDetailsService.patientRegister(regPatient);
		return new ResponseEntity<PatientDetailsDto>(patientDetailsDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{patientId}")
	public ResponseEntity<PatientDetailsDto> getPatient(@PathVariable String patientId) {
		
		PatientDetailsDto patient = patientDetailsService.getPatientById(patientId);
		return ResponseEntity.ok(patient);
	}
	
	@GetMapping("/validatePatient/{patientId}")
	public ResponseEntity<Void> validatePatient(@PathVariable String id){
		patientDetailsService.validateById(id);
		return ResponseEntity.ok().build();
	}
	
}
