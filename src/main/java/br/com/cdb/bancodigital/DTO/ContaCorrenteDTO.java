package br.com.cdb.bancodigital.DTO;

public class ContaCorrenteDTO extends ContaDTO {

	private static final long serialVersionUID = 1L;
	
	private Double taxaMensal;
	
	public ContaCorrenteDTO() {
		
	}
	
	public ContaCorrenteDTO(Double taxaMensal, Long contaId, String contaTipo, Double contaSaldo) {
		super(contaId, contaTipo, contaSaldo);
		this.taxaMensal = taxaMensal;
	}

	public Double getTaxaMensal() {
		return taxaMensal;
	}

	public void setTaxaMensal(Double taxaMensal) {
		this.taxaMensal = taxaMensal;
	}
	
	
}
