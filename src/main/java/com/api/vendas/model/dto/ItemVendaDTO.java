package com.api.vendas.model.dto;

import com.api.vendas.model.Produto;

import jakarta.validation.constraints.NotNull;

public class ItemVendaDTO {

	@NotNull
	private Produto produto;
	
	@NotNull
	private Integer quantidadeVenda;

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidadeVenda() {
		return quantidadeVenda;
	}

	public void setQuantidadeVenda(Integer quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}
	
	
}
