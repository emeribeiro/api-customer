package com.example.api.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.api.form.CustomerAddressForm;
import com.example.api.types.AddressType;

@Entity
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Customer customer;
	
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
    private String numero;
    @Enumerated(EnumType.STRING)
    private AddressType type;
	
	public CustomerAddress() {}

	public CustomerAddress(CustomerAddressForm form, Customer customer) {
		this.customer = customer;
		this.cep = form.getCep();
		this.logradouro = form.getLogradouro();
		this.complemento = form.getComplemento();
		this.bairro = form.getBairro();
		this.localidade = form.getLocalidade();
		this.uf = form.getUf();
		this.ibge = form.getIbge();
		this.gia = form.getGia();
		this.ddd = form.getDdd();
		this.siafi = form.getSiafi();
		this.numero = form.getNumero();
		this.type = form.getType();
	}

	public Long getId() {
		return id;
	}


	public Customer getCustomer() {
		return customer;
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
	
	public String getNumero() {
		return numero;
	}
	
	public AddressType getType() {
		return type;
	}
	
	

}
