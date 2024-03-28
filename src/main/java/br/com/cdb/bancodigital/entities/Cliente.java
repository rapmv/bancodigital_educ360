package br.com.cdb.bancodigital.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clienteId;
	private String cpf;
	private String nome;
	private String categoria;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataNascimento;
	
	@OneToMany(mappedBy = "listaCliente")
	private List<Conta> listaContas = new ArrayList<>();

	
	@Embedded
	private Endereco endereco;
	
	public Cliente () {
		
	}
	
	

	public Cliente(Long clienteId, String cpf, String nome, String categoria, Instant dataNascimento, Endereco endereco) {
		this.clienteId = clienteId;
		this.cpf = cpf;
		this.nome = nome;
		this.categoria = categoria;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public Long getId() {
		return clienteId;
	}

	public void setId(Long clienteId) {
		this.clienteId = clienteId;
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
	
	public List<Conta> getListaContas() {
		return listaContas;
	}

	public void setListaContas(List<Conta> listaContas) {
		this.listaContas = listaContas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clienteId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(clienteId, other.clienteId);
	}
}
