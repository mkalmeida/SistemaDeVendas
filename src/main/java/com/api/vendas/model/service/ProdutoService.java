package com.api.vendas.model.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vendas.model.Produto;
import com.api.vendas.model.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public Object save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Optional<Produto> findByID(UUID idProduto) {
		return produtoRepository.findById(idProduto);
	}

	@Transactional
	public void delete(Produto produto) {
		produtoRepository.delete(produto);
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

}
