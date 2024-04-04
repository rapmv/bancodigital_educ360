package br.com.cdb.bancodigital.DTO;

import br.com.cdb.bancodigital.entities.ContaCorrente;

public class ContaCorrenteDTO extends ContaDTO {

	private static final long serialVersionUID = 1L;
	
	private Double taxaMensal;
	
	public ContaCorrenteDTO() {
		super();
	}
	
	public ContaCorrenteDTO(Double taxaMensal, Long contaId, String contaTipo, Double contaSaldo, ClienteDTO clienteConta) {
		super(contaId, contaTipo, contaSaldo, clienteConta);
		this.taxaMensal = taxaMensal;
	}
	
	public ContaCorrenteDTO(ContaCorrente entity) {
		super(entity);
		//super(entity.getContaId(), entity.getContaTipo(), entity.getContaSaldo(), new ClienteDTO(entity.getClienteConta()));
		this.taxaMensal = entity.getTaxaMensal();
	}

	public Double getTaxaMensal() {
		return taxaMensal;
	}

	public void setTaxaMensal(Double taxaMensal) {
		this.taxaMensal = taxaMensal;
	}
	
	
}
