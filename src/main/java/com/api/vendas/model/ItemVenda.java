package com.api.vendas.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemVenda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItensVendaPK id = new ItensVendaPK();
	
	private Integer qtd;

	private Double precoTotal;

	@ManyToOne
	@JoinColumn(name="venda_id", referencedColumnName = "id", insertable=false, updatable=false)
	private Venda venda; 
	
	
	@ManyToOne
	@JoinColumn(name="produto_id", referencedColumnName = "idProduto", insertable=false, updatable=false)
	private Produto produto;
	
	public ItemVenda() {
		super();
	}

	public ItemVenda(ItensVendaPK id, Integer qtd, Double precoTotal, Venda venda, Produto produto) {
		super();
		this.id = id;
		this.qtd = qtd;
		this.precoTotal = precoTotal;
		this.venda = venda;
		this.produto = produto;
	}


	public ItensVendaPK getId() {
		return id;
	}


	public Integer getQtd() {
		return qtd;
	}


	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	
	public Double getPrecoTotal() {
		for (int i =0; i<produto.getItens().size();i++) {
			precoTotal = precoTotal + produto.getPreco()*qtd;
		}
		return precoTotal;
	}


	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}


	public void setId(ItensVendaPK id) {
		this.id = id;
	}


	public Venda getVenda() {
		return venda;
	}


	public void setVenda(Venda venda) {
		this.venda = venda;
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
	
	
	
}