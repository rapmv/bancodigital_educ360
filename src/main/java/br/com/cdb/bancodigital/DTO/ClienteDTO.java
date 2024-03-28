package br.com.cdb.bancodigital.DTO;

import java.io.Serializable;
import java.time.Instant;

import br.com.cdb.bancodigital.entities.Cliente;
import br.com.cdb.bancodigital.entities.Endereco;
import jakarta.validation.constraints.PastOrPresent;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cpf;
	private String nome;
	private String categoria;
	
	@PastOrPresent(message = "A data não pode ser futura!")
	private Instant dataNascimento;
	
	Endereco endereco;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(Long id, String cpf, String nome, String categoria, Instant dataNascimento, Endereco endereco) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.categoria = categoria;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}
	
	public ClienteDTO(Cliente entity) {
		this.id = entity.getId();
		this.cpf = entity.getCpf();
		this.nome = entity.getNome();
		this.categoria = entity.getCategoria();
		this.dataNascimento = entity.getDataNascimento();
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
	
	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
