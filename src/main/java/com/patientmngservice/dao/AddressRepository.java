package com.patientmngservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientmngservice.model.Address;



public interface AddressRepository extends JpaRepository<Address,Long>{
	

}
