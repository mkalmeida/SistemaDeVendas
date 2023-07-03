package com.api.vendas.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
@Entity
@Table(name="Itens_Venda")
public class ItemVenda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private Integer quantidadeVenda;
	
	private Double SubTotal;
	
	private Double precoProd;

	@OneToOne
	@JoinColumn
	private Produto produto;
	
	public ItemVenda() {
	}

	public ItemVenda(UUID id, Integer quantidadeVenda, Double subTotal, Double precoProd, Produto produto) {
		super();
		this.id = id;
		this.quantidadeVenda = quantidadeVenda;
		SubTotal = subTotal;
		this.precoProd = precoProd;
		this.produto = produto;
	}

	public UUID getId() {
		return id;
	}

	public Integer getQuantidadeVenda() {
		return quantidadeVenda;
	}

	public void setQuantidadeVenda(Integer quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSubTotal(Double subTotal) {
		this.SubTotal = subTotal;
	}

	public Double getSubTotal() {
		return getPrecoProd() * getQuantidadeVenda();
	}

	public Double getPrecoProd() {
		return this.produto.getPreco();
	}

	public void setPrecoProd(Double precoProd) {
		this.precoProd = precoProd;
	}

}
	
	
