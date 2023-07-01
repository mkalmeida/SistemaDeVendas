package com.api.vendas.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vendas.model.Categoria;
import com.api.vendas.model.repository.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Transactional
	public Object save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Optional<Categoria> findByID(Long id) {
		return categoriaRepository.findById(id);
	}

	@Transactional
	public void delete(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
}
