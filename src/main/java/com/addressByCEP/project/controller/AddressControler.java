package com.addressByCEP.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressByCEP.project.service.AddressService;


@RestController
@RequestMapping(value = "/cep")
public class AddressControler {
	
	@Autowired
	private AddressService service;
	
	@GetMapping("/{cep}")
	public ResponseEntity<AddressService> findByCep(@PathVariable String cep){
		
		return null;
	}

}
