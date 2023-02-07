package com.addressByCEP.project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.addressByCEP.project.model.AddressViaCep;

@Repository
public class AddressRepository {
	
	public AddressViaCep findAddress(String cep) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
		
		AddressViaCep response = new AddressViaCep();
		response = restTemplate.getForObject(url, AddressViaCep.class);
		
		return response;
	}

}
