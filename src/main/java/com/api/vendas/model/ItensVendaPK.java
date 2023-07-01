package com.api.vendas.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ItensVendaPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "venda_id")  
	private UUID vendaId;
	
	@Column(name = "produto_id")  
	private UUID produtoId;
	
}
