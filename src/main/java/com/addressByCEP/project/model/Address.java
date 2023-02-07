package com.addressByCEP.project.model;


public class Address {
	
	private String cep; //cep
	private String rua; //logradouro
	private String complemento;
	private String bairro; //bairro
	private String cidade; //localidade
	private String estado; //uf
	private Double frete;
	
	
	public Address() {
		super();
	}

	public Address(String cep, String rua, String complemento, String bairro, String cidade, String estado,
			Double frete) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.frete = frete;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getFrete() {
		return frete;
	}

	public void setFrete(Double frete) {
		this.frete = frete;
	}
	
	
}
