package com.api.vendas.model.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vendas.model.Cliente;
import com.api.vendas.model.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Object save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Optional<Cliente> findByID(UUID id) {
		return clienteRepository.findById(id);
	}

	@Transactional
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
}
