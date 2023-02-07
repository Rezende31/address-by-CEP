package com.addressByCEP.project.model;

public class ResponseErro {

	private boolean erro;
	
	public ResponseErro() {
		super();
	}

	public ResponseErro(boolean erro) {
		super();
		this.erro = erro;
	}

	public boolean isErro() {
		return erro;
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}
	
}
