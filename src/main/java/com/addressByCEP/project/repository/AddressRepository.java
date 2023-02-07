package com.addressByCEP.project.repository;

import org.springframework.web.client.RestTemplate;

import com.addressByCEP.project.model.Address;

public class AddressRepository {
	
	public Address findAddress(String cep) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
		
		Address response = new Address();
		response = restTemplate.getForObject(url, Address.class);
		
		return response;
	}

}
