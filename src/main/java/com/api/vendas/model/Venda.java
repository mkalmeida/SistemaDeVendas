package com.api.vendas.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="VENDA")
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@OneToOne
	@JoinColumn
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn
	private Usuario usuario;
	
	private Double valorPago;
	
	private Double troco;
	
	private Double valorTotal;
	
	private LocalDateTime dataHoraCriacao;
	
	@OneToMany(targetEntity=ItemVenda.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venda", referencedColumnName = "id")
	private List<ItemVenda> items = new ArrayList<>();
	
	public Venda() {
	}
	
	public Venda(UUID id, Cliente cliente, Usuario usuario, Double valorPago, Double troco,
			Double valorTotal, LocalDateTime dataHoraCriacao, List<ItemVenda> items) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.usuario = usuario;
		this.valorPago = valorPago;
		this.troco = troco;
		this.valorTotal = valorTotal;
		this.dataHoraCriacao = dataHoraCriacao;
		this.items = items;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		try {
		if(valorPago>valorTotal) {
			this.valorPago = valorPago;
		}
		} catch(Exception e) {
		System.out.println("ERRO - Valor pago inferior ao total da compra");
		}
	}

	public Double getTroco() {
		if(valorTotal<valorPago) {
			troco = valorPago - valorTotal;
		} else {
			troco = 0.0;
		}
		return troco;
	}

	public void setTroco(Double troco) {
		this.troco = troco;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}

	public List<ItemVenda> getItems() {
		return items;
	}

	public void setItems(List<ItemVenda> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}