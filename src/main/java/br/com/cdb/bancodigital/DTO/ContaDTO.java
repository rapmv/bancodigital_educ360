package br.com.cdb.bancodigital.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.cdb.bancodigital.entities.Cartao;
import br.com.cdb.bancodigital.entities.Cliente;
import br.com.cdb.bancodigital.entities.Conta;

public class ContaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long contaId;
	private String contaTipo;
	private Double saldo;
	
	private Cliente cliente;
	
	private List<CartaoDTO> listaCartoes = new ArrayList<>();
	
	public ContaDTO() {
		
	}

	public ContaDTO(Long contaId, String contaTipo, Double saldo) {
		this.contaId = contaId;
		this.contaTipo = contaTipo;
		this.saldo = saldo;
	}

	public ContaDTO(Conta entity) {
		this.contaId = entity.getContaId();
		this.contaTipo = entity.getContaTipo();
		this.saldo = entity.getSaldo();
	}
	
	public ContaDTO(Conta entity, List<Cartao> listaCartoes) {
		this(entity);
		listaCartoes.forEach(cart->this.listaCartoes.add(new CartaoDTO(cart)));	
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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<CartaoDTO> getListaCartoes() {
		return listaCartoes;
	}

	public void setListaCartoes(List<CartaoDTO> listaCartoes) {
		this.listaCartoes = listaCartoes;
	}	
	
}
