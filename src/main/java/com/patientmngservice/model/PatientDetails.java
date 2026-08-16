package com.patientmngservice.model;

import java.time.LocalDate;

import com.patientmngservice.utils.PatientEntityListner;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Patient_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(value = PatientEntityListner.class)
@Builder
public class PatientDetails {

	@Id
	@Column(name = "patient_id")
	private String patientId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth; // Stored in 'YYYY-MM-DD' format.

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

}
