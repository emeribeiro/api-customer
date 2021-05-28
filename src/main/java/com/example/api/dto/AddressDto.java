package com.example.api.dto;

import com.example.api.domain.Address;

public class AddressDto {
	
	private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    
	public AddressDto(Address address) {
		super();
		this.cep = address.getCep();
		this.logradouro = address.getLogradouro();
		this.complemento = address.getComplemento();
		this.bairro = address.getBairro();
		this.localidade = address.getLocalidade();
		this.uf = address.getUf();
		this.ibge = address.getIbge();
		this.gia = address.getGia();
		this.ddd = address.getDdd();
		this.siafi = address.getSiafi();
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}

	public String getIbge() {
		return ibge;
	}

	public String getGia() {
		return gia;
	}

	public String getDdd() {
		return ddd;
	}

	public String getSiafi() {
		return siafi;
	}
    
 
	
}
