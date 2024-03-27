package br.com.cdb.bancodigital.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;


@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private String estado;
	private String cidade;
	private String rua;
	private String numero;
	private String logradouro;
	
	public Endereco(){
		
	}

	public Endereco(String estado, String cidade, String rua, String numero, String logradouro) {
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
		this.logradouro = logradouro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}	
}
