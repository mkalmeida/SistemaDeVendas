package com.api.vendas.model.dto;

import jakarta.validation.constraints.NotBlank;

public class UsuarioDto {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	private String usuario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
