package com.addressByCEP.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressByCEP.project.exception.InvalidCepException;
import com.addressByCEP.project.model.Address;
import com.addressByCEP.project.model.CepRequest;
import com.addressByCEP.project.service.AddressService;


@RestController
@RequestMapping(value = "/v1")
public class AddressControler {
	
	@Autowired
	private AddressService service;
	
	@PostMapping
	public ResponseEntity<Address> findByCep(@RequestBody CepRequest cep){
		Address address =  service.findAddress(cep.getCep());
		return ResponseEntity.ok().body(address);
		
//		try {
//			
//		}catch (InvalidCepException e) {
//	        return ResponseEntity.badRequest().build();
//		}
	}

}
