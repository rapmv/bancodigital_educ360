package br.com.cdb.bancodigital.DTO;

import java.io.Serializable;

import br.com.cdb.bancodigital.entities.Cliente;
import br.com.cdb.bancodigital.entities.Endereco;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cpf;
	private String nome;
	private String categoria;
	
	Endereco endereco;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(Long id, String cpf, String nome, String categoria, Endereco endereco) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.categoria = categoria;
		this.endereco = endereco;
	}
	
	public ClienteDTO(Cliente entity) {
		this.id = entity.getId();
		this.cpf = entity.getCpf();
		this.nome = entity.getNome();
		this.categoria = entity.getCategoria();
		this.endereco = entity.getEndereco();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
