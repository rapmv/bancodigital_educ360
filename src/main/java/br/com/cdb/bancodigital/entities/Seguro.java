package br.com.cdb.bancodigital.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_seguro")
public class Seguro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seguroId;
	private Long seguroNumeroApolice;
	private String seguroCondicoes;
	private String seguroDetalhesCartao;
	private Double seguroValorApolice;
	private String seguroDescricao;
	
	
	private LocalDate seguroDataContrato;
	
	@OneToOne()
	@JoinColumn(name="cartao_id")
	private Cartao cartaoSeguro;
	
	public Seguro() {
		
	}

	public Seguro(Long seguroId, Long seguroNumeroApolice, String seguroCondicoes, String seguroDetalhesCartao,
			Double seguroValorApolice, String seguroDescricao, LocalDate seguroDataContrato) {
		super();
		this.seguroId = seguroId;
		this.seguroNumeroApolice = seguroNumeroApolice;
		this.seguroCondicoes = seguroCondicoes;
		this.seguroDetalhesCartao = seguroDetalhesCartao;
		this.seguroValorApolice = seguroValorApolice;
		this.seguroDescricao = seguroDescricao;
		this.seguroDataContrato = seguroDataContrato;
	}

	public Long getSeguroId() {
		return seguroId;
	}

	public void setSeguroId(Long seguroId) {
		this.seguroId = seguroId;
	}

	public Long getSeguroNumeroApolice() {
		return seguroNumeroApolice;
	}

	public void setSeguroNumeroApolice(Long seguroNumeroApolice) {
		this.seguroNumeroApolice = seguroNumeroApolice;
	}

	public String getSeguroCondicoes() {
		return seguroCondicoes;
	}

	public void setSeguroCondicoes(String seguroCondicoes) {
		this.seguroCondicoes = seguroCondicoes;
	}

	public String getSeguroDetalhesCartao() {
		return seguroDetalhesCartao;
	}

	public void setSeguroDetalhesCartao(String seguroDetalhesCartao) {
		this.seguroDetalhesCartao = seguroDetalhesCartao;
	}

	public Double getSeguroValorApolice() {
		return seguroValorApolice;
	}

	public void setSeguroValorApolice(Double seguroValorApolice) {
		this.seguroValorApolice = seguroValorApolice;
	}

	public String getSeguroDescrição() {
		return seguroDescricao;
	}

	public void setSeguroDescrição(String seguroDescricao) {
		this.seguroDescricao = seguroDescricao;
	}

	public LocalDate getSeguroDataContrato() {
		return seguroDataContrato;
	}

	public void setSeguroDataContrato(LocalDate seguroDataContrato) {
		this.seguroDataContrato = seguroDataContrato;
	}
	
	public Cartao getCartaoSeguro() {
		return cartaoSeguro;
	}

	public void setCartaoSeguro(Cartao cartaoSeguro) {
		this.cartaoSeguro = cartaoSeguro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(seguroId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seguro other = (Seguro) obj;
		return Objects.equals(seguroId, other.seguroId);
	}
}
