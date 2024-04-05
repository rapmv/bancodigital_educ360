package br.com.cdb.bancodigital.DTO;

import java.io.Serializable;
import java.time.Instant;

import br.com.cdb.bancodigital.entities.Cartao;
import br.com.cdb.bancodigital.entities.Seguro;

public class CartaoDTO implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private Long cartaoId;
		private String cartaoTipo;
		private String cartaoStatus;
		private String cartaoSenha;
		private Double cartaoLimite;
		private Double cartaoLimiteUsado;
		
		private Instant cartaoData;
		
		private ContaDTO contaCartao = new ContaDTO();
		
		private Seguro seguro;
		
		public CartaoDTO() {
			
		}

		public CartaoDTO(Long cartaoId, String cartaoTipo, String cartaoStatus, String cartaoSenha, 
				Double cartaoLimite, Double cartaoLimiteUsado, Instant cartaoData, ContaDTO contaCartao) {
			this.cartaoId = cartaoId;
			this.cartaoTipo = cartaoTipo;
			this.cartaoStatus = cartaoStatus;
			this.cartaoSenha = cartaoSenha;
			this.cartaoLimite = cartaoLimite;
			this.cartaoLimiteUsado = cartaoLimiteUsado;
			this.cartaoData = cartaoData;
			
			this.contaCartao = contaCartao;
		}
		
		public CartaoDTO(Cartao entity) {
			this.cartaoId = entity.getCartaoId();
			this.cartaoTipo = entity.getCartaoTipo();
			this.cartaoStatus = entity.getCartaoStatus();
			this.cartaoSenha = entity.getCartaoSenha();
			this.cartaoLimite = entity.getCartaoLimite();
			this.cartaoLimiteUsado = entity.getCartaoLimiteUsado();
			this.cartaoData = entity.getCartaoData();
			
			this.contaCartao = new ContaDTO(entity.getContaCartao());
		}
		
		/*
		public CartaoDTO(Cartao entity, Seguro seguro) {
			this(entity);
			this.seguro = seguro;
		}
		*/
		
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

		public ContaDTO getContaCartao() {
			return contaCartao;
		}

		public void setContaCartao(ContaDTO contaCartao) {
			this.contaCartao = contaCartao;
		}

		public Seguro getSeguro() {
			return seguro;
		}

		public void setSeguro(Seguro seguro) {
			this.seguro = seguro;
		}

}
