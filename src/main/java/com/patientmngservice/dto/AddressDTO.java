package com.patientmngservice.dto;

import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {

	@NotBlank(message = "Street cannot be blank")
	@Size(max = 100, message = "Street must be less than 100 characters")
	private String street;

	@NotBlank(message = "landMark cannot be blank")
	private String landMark;

	@NotBlank(message = "City cannot be blank")
	@Size(max = 50, message = "City must be less than 50 characters")
	private String city;

	@NotBlank(message = "Postal code cannot be blank")
	@Pattern(regexp = "^[0-9]{5,6}$", message = "Postal code must be 5 or 6 digits")
	private String postalCode;

	@NotBlank(message = "State cannot be blank")
	private String state;

	@NotBlank(message = "Country cannot be blank")
	private String country;

}
