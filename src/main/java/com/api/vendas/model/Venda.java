package com.api.vendas.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	@JoinColumn(name="idCliente", insertable=false, updatable=false)
	private Cliente cliente;
	
	private UUID idCliente;
	
	@OneToOne
	@JoinColumn(name="idUsuario", insertable=false, updatable=false)
	private Usuario usuario;
	
	private Long idUsuario;
	
	private Double valorPago;
	
	private Double desconto;
	
	private Double troco;
	
	private LocalDateTime dataHoraCriacao;
	
	@OneToMany(mappedBy="venda")
	private List<ItemVenda> itens =  new ArrayList<ItemVenda>();
	
	public Venda() {
	}
	
	public Venda(UUID id, Cliente cliente, UUID idCliente, Usuario usuario, Long idUsuario, Double valorPago,
			Double desconto, Double troco, LocalDateTime dataHoraCriacao, List<ItemVenda> itens) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.idCliente = idCliente;
		this.usuario = usuario;
		this.idUsuario = idUsuario;
		this.valorPago = valorPago;
		this.desconto = desconto;
		this.troco = troco;
		this.dataHoraCriacao = dataHoraCriacao;
		this.itens = itens;
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

	public UUID getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(UUID idCliente) {
		this.idCliente = idCliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getTroco() {
		return troco;
	}

	public void setTroco(Double troco) {
		this.troco = troco;
	}

	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
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