package com.addressByCEP.project.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.addressByCEP.project.model.AddressViaCep;

@Repository
public class AddressRepository {
	
	public AddressViaCep findAddress(String cep)  {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
		
		AddressViaCep response = new AddressViaCep();
		response = restTemplate.getForObject(url, AddressViaCep.class);
		
		return response;
		
		
//		try {
//            ResponseEntity<AddressViaCep> responseTest = restTemplate.getForEntity(url, AddressViaCep.class);
//            if (responseTest.getStatusCode() == HttpStatus.OK) {
//                return responseTest.getBody();
//            }
//        } catch (HttpClientErrorException e) {
//            // retorna um objeto Endereco com erro=true
//            return new AddressViaCep().withErro(true);
//        }
//        return null;
		
	}

}
