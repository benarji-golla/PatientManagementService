package com.patientmngservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patientmngservice.dto.PatientDetailsDto;
import com.patientmngservice.model.PatientDetails;


@Repository
public interface PatientRepository extends JpaRepository<PatientDetails,String> {

	@Query(value="SELECT patient_id from Patient_Details where patient_id like 'PATIENT%' ORDER BY patient_id desc limit 1 ", nativeQuery = true)
	String findLastpatientId();


	
}
