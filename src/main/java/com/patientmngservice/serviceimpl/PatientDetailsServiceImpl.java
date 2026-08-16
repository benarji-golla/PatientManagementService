package com.patientmngservice.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.patientmngservice.builder.PatientDetatilsBuilder;
import com.patientmngservice.dao.PatientRepository;
import com.patientmngservice.dto.PatientDetailsDto;
import com.patientmngservice.dto.RegisterPatientDto;
import com.patientmngservice.exception.PatientDetailsException;
import com.patientmngservice.exception.PatientNotFoundException;
import com.patientmngservice.model.PatientDetails;
import com.patientmngservice.service.PatientDetailsService;
import com.patientmngservice.utils.Constants;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientDetailsServiceImpl implements PatientDetailsService {

	private final PatientRepository patientRepository;
	
	private final Logger logger = LoggerFactory.getLogger(PatientDetailsServiceImpl.class);
	@Override
	public PatientDetailsDto patientRegister(RegisterPatientDto regPatient) {
		try {
		PatientDetails patient = PatientDetatilsBuilder.buildPatientFromDTO(regPatient);
		PatientDetails savedPatient =  patientRepository.save(patient);
		logger.info("patient " + Constants.CREATED, savedPatient.getPatientId());
		return PatientDetatilsBuilder.buildPatientDetailsDtoFromPatient(savedPatient) ;
		}
		catch(Exception e) {
		throw new PatientDetailsException("Constants.ERROR + \" registering patient: \" + e.getMessage()");
		}
	}
	@Override
	public PatientDetailsDto getPatientById(String patientId) {
		if(patientId == null && patientId.isBlank()) {
			throw new PatientNotFoundException("patientId can not be NULL"); 
		} 
	try {
		PatientDetails patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("patient \" + Constants.NOT_FOUND + patient"));		
	return PatientDetatilsBuilder.buildPatientDetailsDtoFromPatient(patient) ;
	}
	 catch (DataAccessException e) {
		logger.error("{} fetching patient details with ID: {} - Exception: {}", Constants.ERROR, patientId,
				e.getMessage());
		throw new PatientNotFoundException(Constants.ERROR + " fetching patient details with ID: " + patientId);
	} catch (PatientNotFoundException e) {
		logger.warn(e.getMessage());
		throw e;
	} catch (Exception e) {
		logger.error("{} fetching patient details with ID: {} - Exception - {}", Constants.ERROR, patientId, e);
		throw new PatientNotFoundException(Constants.ERROR + " fetching patient details with ID: " + patientId);
	}
	}

}
