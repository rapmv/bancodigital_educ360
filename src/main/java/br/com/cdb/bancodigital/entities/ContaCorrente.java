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
		super();
	}
	
	public ContaCorrente(Double taxaMensal, Long contaId, String contaTipo, Double contaSaldo, Cliente listaCliente) {
		super(contaId, contaTipo, contaSaldo, listaCliente);
		this.taxaMensal = taxaMensal;
	}

	public Double getTaxaMensal() {
		return taxaMensal;
	}

	public void setTaxaMensal(Double taxaMensal) {
		this.taxaMensal = taxaMensal;
	}
	
	

}
