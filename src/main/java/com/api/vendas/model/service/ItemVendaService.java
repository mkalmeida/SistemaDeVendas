package com.api.vendas.model.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vendas.model.ItemVenda;
import com.api.vendas.model.Produto;
import com.api.vendas.model.Venda;
import com.api.vendas.model.repository.ItemVendaRepository;

import jakarta.transaction.Transactional;

@Service
public class ItemVendaService {

	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	@Transactional
	public Object save(ItemVenda itemVenda) {
		return itemVendaRepository.save(itemVenda);
	}

	public Optional<ItemVenda> findByID(UUID id) {
		return itemVendaRepository.findById(id);
	}

	@Transactional
	public void delete(ItemVenda itemVenda) {
		itemVendaRepository.delete(itemVenda);
	}

	public List<ItemVenda> findAll() {
		return itemVendaRepository.findAll();
	}

}


