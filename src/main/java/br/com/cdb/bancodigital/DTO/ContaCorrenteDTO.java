package br.com.cdb.bancodigital.DTO;

import java.util.List;

import br.com.cdb.bancodigital.entities.Cartao;
import br.com.cdb.bancodigital.entities.ContaCorrente;

public class ContaCorrenteDTO extends ContaDTO {

	private static final long serialVersionUID = 1L;
	
	private Double taxaMensal;
	
	public ContaCorrenteDTO() {
		
	}
	
	public ContaCorrenteDTO(Double taxaMensal, Long contaId, String contaTipo, ClienteDTO listaCliente) {
		super(contaId, contaTipo, listaCliente);
		this.taxaMensal = taxaMensal;
	}
	
	public ContaCorrenteDTO(ContaCorrente entity) {
		super(entity.getContaId(), entity.getContaTipo(), new ClienteDTO(entity.getListaCliente()));
		this.taxaMensal = entity.getTaxaMensal();
	}
	
	
	/*
	public ContaCorrenteDTO(ContaCorrente entity, List<Cartao> listaCartoes) {
		this(entity);
		listaCartoes.forEach(cart->this.listaCartoes.add(new CartaoDTO(cart)));
	}
	*/


	public Double getTaxaMensal() {
		return taxaMensal;
	}

	public void setTaxaMensal(Double taxaMensal) {
		this.taxaMensal = taxaMensal;
	}
	
	
}
