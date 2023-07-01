package com.api.vendas.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vendas.model.Usuario;
import com.api.vendas.model.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Object save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Optional<Usuario> findByID(Long id) {
		return usuarioRepository.findById(id);
	}

	@Transactional
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
}
