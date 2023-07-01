package com.api.vendas.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Itens_Venda")
public class ItemVenda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private Integer quantidadeVenda;

	@OneToOne
	@JoinColumn
	private Produto produto;
	
	@ManyToOne
	private Venda venda;
	
	public ItemVenda() {
	}

	public ItemVenda(UUID id, Integer quantidadeVenda, Produto produto, Venda venda) {
		super();
		this.id = id;
		this.quantidadeVenda = quantidadeVenda;
		this.produto = produto;
		this.venda = venda;
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
	
	public Double getSubTotal() {
        //return this.produto.getPreco() * quantidadeVenda;
		return 0.0;
    }

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	
}