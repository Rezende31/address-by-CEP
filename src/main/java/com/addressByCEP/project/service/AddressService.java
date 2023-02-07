package com.addressByCEP.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.addressByCEP.project.model.Address;
import com.addressByCEP.project.repository.AddressRepository;

public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	
	public Address findAddress(String cep) {
		return null;
	}
	
	
	public boolean isCepValid(String cep) {
	    if (cep == null || cep.length() != 8) {
	        return false;
	    }
	    return cep.matches("[0-9]{8}");
	}

}
