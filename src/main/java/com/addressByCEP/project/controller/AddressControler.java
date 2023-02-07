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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "v1/consulta-endereco")
@Api(value = "Endereço", description = "Consulta endereço e cálculo de frete por CEP")
public class AddressControler {
	
	@Autowired
	private AddressService service;
	
	@PostMapping
	@ApiOperation(value = "Consulta endereço e cálculo de frete por CEP")
	public ResponseEntity<Address> findByCep(@RequestBody CepRequest cep) {
		try {
			cep.setCep(cep.getCep().replaceAll("-", ""));
			if(!service.isCepValid(cep.getCep())) {
				return ResponseEntity.badRequest().build();
			}
			
			Address address =  service.findAddress(cep.getCep());
			
//			String json = "{\"error\": true}";
//			ObjectMapper mapper = new ObjectMapper();
//			
//			ResponseErro erro = mapper.readValue(json, ResponseErro.class);
			
			return ResponseEntity.ok().body(address);
			
		} catch (InvalidCepException e) {
	        return ResponseEntity.notFound().build();
	    }
		
		
	}

}
