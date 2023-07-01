package com.api.vendas.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	private Double valorPago;
	
	private List<ItemVenda> items = new ArrayList<>();
	
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

	public List<ItemVenda> getItems() {
		return items;
	}

	public void setItems(List<ItemVenda> items) {
		this.items = items;
	}

	
}
