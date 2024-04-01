package br.com.cdb.bancodigital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_conta_corrente")
@PrimaryKeyJoinColumn(name="contaId")
public class ContaCorrente extends Conta{
	
	private Double taxaMensal;
	
	public ContaCorrente() {
	}
	
	public ContaCorrente(Double taxaMensal, Double taxaRendimento, Long contaId, String contaTipo, Double contaSaldo) {
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
