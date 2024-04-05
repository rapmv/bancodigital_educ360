package br.com.cdb.bancodigital.DTO;

import br.com.cdb.bancodigital.entities.ContaPoupanca;

public class ContaPoupancaDTO extends ContaDTO {

	private static final long serialVersionUID = 1L;
	
	private Double taxaRendimento;
	
	public ContaPoupancaDTO() {
		super();
	}
	
	public ContaPoupancaDTO(Double taxaMensal, Long contaId, String contaTipo, Double contaSaldo, ClienteDTO clienteConta) {
		super(contaId, contaTipo, contaSaldo, clienteConta);
		this.taxaRendimento = taxaRendimento;
	}
	
	public ContaPoupancaDTO(ContaPoupanca entity) {
		super(entity);
		this.taxaRendimento = entity.getTaxaRendimento();
	}

	public Double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(Double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
	
	
}
