package com.api.vendas.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String nome;
		
		private String senha;
		
		private String usuario;
		
		private LocalDateTime ultimoLogin;
		
		//quando você cria um usuário o estado é verdadeiro (ao instanciar um objeto)
		public Usuario() {
		}
		
		public Usuario(Long id, String nome, String senha, String usuario, LocalDateTime ultimoLogin) {
			super();
			this.id = id;
			this.nome = nome;
			this.senha = senha;
			this.usuario = usuario;
			this.ultimoLogin = ultimoLogin;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

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


		public LocalDateTime getUltimoLogin() {
			return ultimoLogin;
		}
		
		public void setUltimoLogin(LocalDateTime ultimoLogin) {
			this.ultimoLogin = ultimoLogin;
		}

}
