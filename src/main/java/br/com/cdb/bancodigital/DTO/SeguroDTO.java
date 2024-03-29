package br.com.cdb.bancodigital.DTO;

import java.io.Serializable;
import java.time.Instant;

public class SeguroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long seguroId;
	private Long seguroNumeroApolice;
	private String seguroCondicoes;
	private String seguroDetalhesCartao;
	private Double seguroValorApolice;
	private String seguroDescricao;
	
	private Instant seguroDataContrato;
	
	public SeguroDTO() {
		
	}

	public SeguroDTO(Long seguroId, Long seguroNumeroApolice, String seguroCondicoes, String seguroDetalhesCartao,
			Double seguroValorApolice, String seguroDescricao, Instant seguroDataContrato) {
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

	public String getSeguroDescricao() {
		return seguroDescricao;
	}

	public void setSeguroDescricao(String seguroDescricao) {
		this.seguroDescricao = seguroDescricao;
	}

	public Instant getSeguroDataContrato() {
		return seguroDataContrato;
	}

	public void setSeguroDataContrato(Instant seguroDataContrato) {
		this.seguroDataContrato = seguroDataContrato;
	}
	
	
}
