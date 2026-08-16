package com.patientmngservice.utils;

import org.springframework.stereotype.Component;

import com.patientmngservice.dao.PatientRepository;

@Component
public class PatientIdGenarator {

    private final PatientRepository patientRepository;
    
    public PatientIdGenarator(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}



	public  String generateNextStaffId() {
        String lastId = patientRepository.findLastpatientId();
        int nextNumber = 1;

        if (lastId != null && lastId.startsWith("PATIENT-")) {
            String numberPart = lastId.substring(8);
            nextNumber = Integer.parseInt(numberPart) + 1;
            return String.format("PATIENT-%05d", nextNumber);
        }

        return String.format("PATIENT-%05d", nextNumber);
    }
	
}
