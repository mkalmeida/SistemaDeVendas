package com.api.vendas.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.api.vendas.model.Cliente;
import com.api.vendas.model.ItemVenda;
import com.api.vendas.model.Produto;
import com.api.vendas.model.Usuario;

import jakarta.validation.constraints.NotNull;

public class VendaDto {
	
	@NotNull
	private Cliente cliente;
	
	@NotNull
	private Usuario usuario;
	
	@NotNull
	private Double valorPago;
	
	@NotNull
	private Double desconto;
	
	private List<ItemVenda> itens =  new ArrayList<ItemVenda>();
	
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
		this.valorPago = valorPago;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}


}
