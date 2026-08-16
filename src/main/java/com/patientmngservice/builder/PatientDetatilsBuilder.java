package com.patientmngservice.builder;

import com.patientmngservice.dto.AddressDTO;
import com.patientmngservice.dto.PatientDetailsDto;
import com.patientmngservice.dto.RegisterPatientDto;
import com.patientmngservice.model.Address;
import com.patientmngservice.model.PatientDetails;

public class PatientDetatilsBuilder {

	public static PatientDetails buildPatientFromDTO(RegisterPatientDto dto) {
		if (dto == null) {
			return null;
		}

		return PatientDetails.builder()
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.email(dto.getEmail())
				.phoneNumber(dto.getPhoneNumber())
				.gender(dto.getGender())
				.dateOfBirth(dto.getDateOfBirth())
				.address(Address.builder()
						.street(dto.getAddressDTO().getStreet())
						.landMark(dto.getAddressDTO().getLandMark())
						.city(dto.getAddressDTO().getCity())
						.state(dto.getAddressDTO().getState())
						.postalCode(dto.getAddressDTO().getPostalCode())
						.country(dto.getAddressDTO().getCountry()).build())
				.build();
	}

	public static PatientDetailsDto buildPatientDetailsDtoFromPatient(PatientDetails patient) {
		if (patient == null) {
			return null;
		}

		return PatientDetailsDto.builder()
				.patientId(patient.getPatientId())
				.firstName(patient.getFirstName())
				.lastName(patient.getLastName())
				.email(patient.getEmail())
				.phoneNumber(patient.getPhoneNumber())
				.gender(patient.getGender())
				.dateOfBirth(patient.getDateOfBirth())
				.addressDTO(AddressDTO.builder()
						.street(patient.getAddress().getStreet())
						.landMark(patient.getAddress().getLandMark())
						.city(patient.getAddress().getCity())
						.state(patient.getAddress().getState())
						.postalCode(patient.getAddress().getPostalCode())
						.country(patient.getAddress().getCountry()).build())
				.build();
	}
}
