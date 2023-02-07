package com.addressByCEP.project.model;

public class CepRequest {
	
	private String cep;
	
	public CepRequest() {
		super();
	}
	
	public CepRequest(String cep) {
		super();
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
