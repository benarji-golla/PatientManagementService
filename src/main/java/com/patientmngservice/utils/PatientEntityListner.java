package com.patientmngservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.patientmngservice.model.PatientDetails;

import jakarta.persistence.PrePersist;

@Component
public class PatientEntityListner {


	public static PatientIdGenarator patientIdGenarator;

	@Autowired
	public void init(PatientIdGenarator patientIdGenarator) {

		this.patientIdGenarator = patientIdGenarator;
	}

	@PrePersist
	public void generateStaffId(PatientDetails patient) {
		if (patient.getPatientId() == null || patient.getPatientId().isEmpty()) {
			patient.setPatientId(patientIdGenarator.generateNextStaffId());
		}
	}
	
}
