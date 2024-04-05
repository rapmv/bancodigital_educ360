package br.com.cdb.bancodigital.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.cdb.bancodigital.entities.Cartao;
import br.com.cdb.bancodigital.entities.Conta;

public class ContaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long contaId;
	private String contaTipo;
	private Double contaSaldo;
	
	private ClienteDTO clienteConta = new ClienteDTO();
	
	private List<CartaoDTO> listaCartoes = new ArrayList<>();
	
	public ContaDTO() {
		
	}
	
	public ContaDTO(Long contaId, String contaTipo, Double contaSaldo, ClienteDTO clienteConta) {
		this.contaId = contaId;
		this.contaTipo = contaTipo;
		this.contaSaldo = contaSaldo;
		
		this.clienteConta = clienteConta;
	}
	

	public ContaDTO(Conta entity) {
		
		this.contaId = entity.getContaId();
		this.contaTipo = entity.getContaTipo();
		this.contaSaldo = entity.getContaSaldo();
		this.clienteConta = new ClienteDTO(entity.getClienteConta());
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

	public ClienteDTO getClienteConta() {
		return clienteConta;
	}

	public void setClienteConta(ClienteDTO clienteConta) {
		this.clienteConta = clienteConta;
	}

	public Double getContaSaldo() {
		return contaSaldo;
	}

	public void setContaSaldo(Double contaSaldo) {
		this.contaSaldo = contaSaldo;
	}

	public List<CartaoDTO> getListaCartoes() {
		return listaCartoes;
	}

	public void setListaCartoes(List<CartaoDTO> listaCartoes) {
		this.listaCartoes = listaCartoes;
	}	
	
}
