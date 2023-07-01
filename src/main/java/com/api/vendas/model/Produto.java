package com.api.vendas.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUTO")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idProduto;
	
	private String nome;
	
	private Double preco;
	
	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name="idCategoria", insertable=false, updatable=false)
	private Categoria categoria;
	
	private Long idCategoria;
	
	@OneToMany(mappedBy="produto")
	private List<ItemVenda> itens;

	public Produto() {
	}
	
	public UUID getIdProduto() {
		return idProduto;
	}

	
	public Produto(UUID idProduto, String nome, Double preco, Integer quantidade, Categoria categoria, Long idCategoria) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.categoria = categoria;
		this.idCategoria = idCategoria;
	}
	
	public Produto(UUID idProduto, String nome, Double preco, Integer quantidade, Categoria categoria, Long idCategoria,
			List<ItemVenda> itens) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.categoria = categoria;
		this.idCategoria = idCategoria;
		this.itens = itens;
	}

	public void setIdProduto(UUID idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
