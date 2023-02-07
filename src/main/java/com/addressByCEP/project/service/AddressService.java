package com.addressByCEP.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressByCEP.project.exception.InvalidCepException;
import com.addressByCEP.project.model.Address;
import com.addressByCEP.project.model.AddressViaCep;
import com.addressByCEP.project.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	
	public Address findAddress(String cep) {
		AddressViaCep addressViaCep = new AddressViaCep();
		Address address = new Address();
		
		boolean cepValid = this.isCepValid(cep);
		
		if(cepValid) {
			addressViaCep = repository.findAddress(cep);
			address = this.mapperAddress(addressViaCep);
			return address;
		}
		return null;
	}
	
//	public boolean isCepValid(String cep) throws InvalidCepException {
//	    if (cep == null || cep.length() != 8) {
//	    	throw new InvalidCepException("CEP inválido");
//	    }
//	    return cep.matches("[0-9]{8}");
//	}
	
	public boolean isCepValid(String cep)   {
	    if (!cep.matches("[0-9]{8}")) {
	    	return false;
	    }
	    return true;
	}
	
	
	private Address mapperAddress(AddressViaCep addressViaCep) {
		Address result = new Address();
		result.setCep(addressViaCep.getCep());
		result.setRua(addressViaCep.getLogradouro());
		result.setComplemento(addressViaCep.getComplemento());
		result.setBairro(addressViaCep.getBairro());
		result.setCidade(addressViaCep.getLocalidade());
		result.setEstado(addressViaCep.getUf());
		result.setFrete(this.Calculafrete(addressViaCep.getUf()));
		
		return result;
	}
	
	private double Calculafrete(String estado) {
		if(estado.equals("SP") || estado.equals("RJ") || estado.equals("MG") || estado.equals("ES") ) {
			return 7.85;
		} else if (estado.equals("DF") || estado.equals("GO") || estado.equals("MT") || estado.equals("MS") || estado.equals("TO") ) {
			return 12.50;
		} else if (estado.equals("AL") || estado.equals("BA") || estado.equals("CE") || estado.equals("MA") || estado.equals("PB") ||
				estado.equals("PE") || estado.equals("PI") || estado.equals("RN") || estado.equals("SE") ) {
			return 15.98;
		}else if (estado.equals("PR") || estado.equals("RS") || estado.equals("SC") ) {
			return 17.30;
		}else {
			return 20.83;
		}
		
	}

}
