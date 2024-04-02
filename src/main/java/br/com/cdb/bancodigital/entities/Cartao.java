package br.com.cdb.bancodigital.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cartao")
public class Cartao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartaoId;
	private String cartaoTipo;
	private String cartaoStatus;
	private String cartaoSenha;
	private Double cartaoLimite;
	private Double cartaoLimiteUsado;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant cartaoData;
	
	@ManyToOne()
	@JoinColumn(name="conta_Id", nullable=false)
	private Conta listaConta;
	
	@OneToOne(mappedBy="listaCartao")
	private Seguro seguro;
	
	
	
	public Cartao() {
		
	}

	public Cartao(Long cartaoId, String cartaoTipo, String cartaoStatus, String cartaoSenha, Double cartaoLimite,
			Double cartaoLimiteUsado, Instant cartaoData) {
		super();
		this.cartaoId = cartaoId;
		this.cartaoTipo = cartaoTipo;
		this.cartaoStatus = cartaoStatus;
		this.cartaoSenha = cartaoSenha;
		this.cartaoLimite = cartaoLimite;
		this.cartaoLimiteUsado = cartaoLimiteUsado;
		this.cartaoData = cartaoData;
	}

	public Long getCartaoId() {
		return cartaoId;
	}

	public void setCartaoId(Long cartaoId) {
		this.cartaoId = cartaoId;
	}

	public String getCartaoTipo() {
		return cartaoTipo;
	}

	public void setCartaoTipo(String cartaoTipo) {
		this.cartaoTipo = cartaoTipo;
	}

	public String getCartaoStatus() {
		return cartaoStatus;
	}

	public void setCartaoStatus(String cartaoStatus) {
		this.cartaoStatus = cartaoStatus;
	}

	public String getCartaoSenha() {
		return cartaoSenha;
	}

	public void setCartaoSenha(String cartaoSenha) {
		this.cartaoSenha = cartaoSenha;
	}

	public Double getCartaoLimite() {
		return cartaoLimite;
	}

	public void setCartaoLimite(Double cartaoLimite) {
		this.cartaoLimite = cartaoLimite;
	}

	public Double getCartaoLimiteUsado() {
		return cartaoLimiteUsado;
	}

	public void setCartaoLimiteUsado(Double cartaoLimiteUsado) {
		this.cartaoLimiteUsado = cartaoLimiteUsado;
	}

	public Instant getCartaoData() {
		return cartaoData;
	}

	public void setCartaoData(Instant cartaoData) {
		this.cartaoData = cartaoData;
	}

	public Conta getListaConta() {
		return listaConta;
	}

	public void setListaConta(Conta listaConta) {
		this.listaConta = listaConta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartaoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		return Objects.equals(cartaoId, other.cartaoId);
	}

}
