package br.com.cdb.bancodigital.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_conta")
@Inheritance(strategy = InheritanceType.JOINED)
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contaId;
	private String contaTipo;
	private Double contaSaldo;
	
	@ManyToOne()
	@JoinColumn(name="cliente_id")
	private Cliente listaCliente;
	
	
	@OneToMany(mappedBy="listaConta")
	private List<Cartao> listaCartoes = new ArrayList<>();
	
	
	public Conta() {
		
	}

	public Conta(Long contaId, String contaTipo, Double contaSaldo, Cliente listaCliente) {
		this.contaId = contaId;
		this.contaTipo = contaTipo;
		this.contaSaldo = contaSaldo;
		this.listaCliente = listaCliente;

	}

	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}
	
	public String getContaTipo() {
		return contaTipo;
	}

	public void setContaTipo(String contaTipo) {
		this.contaTipo = contaTipo;
	}

	public Double getContaSaldo() {
		return contaSaldo;
	}

	public void setContaSaldo(Double contaSaldo) {
		this.contaSaldo = contaSaldo;
	}

	public Cliente getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(Cliente cliente) {
		this.listaCliente = cliente;
	}
	
	public List<Cartao> getListaCartoes() {
		return listaCartoes;
	}

	public void setListaCartoes(List<Cartao> listaCartoes) {
		this.listaCartoes = listaCartoes;
	}
	
	public void calcularTaxa() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(contaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(contaId, other.contaId);
	}
}
