package com.patientmngservice.service;

import com.patientmngservice.dto.PatientDetailsDto;
import com.patientmngservice.dto.RegisterPatientDto;

public interface PatientDetailsService {

	public PatientDetailsDto patientRegister(RegisterPatientDto regPatient);

	public PatientDetailsDto getPatientById(String patientId);

}
