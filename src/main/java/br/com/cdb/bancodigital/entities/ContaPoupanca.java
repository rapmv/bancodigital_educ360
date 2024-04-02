package br.com.cdb.bancodigital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_conta_poupanca")
@PrimaryKeyJoinColumn(name="contaId")
public class ContaPoupanca extends Conta{
	
	private Double taxaRendimento;
	
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(Double taxaRendimento, Long contaId, String contaTipo, Double contaSaldo, Cliente listaCliente) {
		super(contaId, contaTipo, contaSaldo, listaCliente);
		this.taxaRendimento = taxaRendimento;
	}

	public Double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(Double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
	
}
