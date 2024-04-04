package br.com.cdb.bancodigital.DTO;

import br.com.cdb.bancodigital.entities.ContaPoupanca;

public class ContaPoupancaDTO extends ContaDTO {

	private static final long serialVersionUID = 1L;
	
	private Double taxaRendimento;
	
	public ContaPoupancaDTO() {
		
	}
	
	public ContaPoupancaDTO(Double taxaRendimento, Long contaId, String contaTipo, ClienteContaDTO clienteConta) {
		super(contaId, contaTipo, clienteConta);
		this.taxaRendimento = taxaRendimento;
	}
	
	public ContaPoupancaDTO(ContaPoupanca entity) {
		super(entity.getContaId(), entity.getContaTipo(), new ClienteContaDTO(entity.getClienteConta()));
		this.taxaRendimento = entity.getTaxaRendimento();
	}

	public Double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(Double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
	
	
}
