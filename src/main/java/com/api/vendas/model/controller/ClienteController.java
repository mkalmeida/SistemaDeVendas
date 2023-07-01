package com.api.vendas.model.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vendas.model.Cliente;
import com.api.vendas.model.dto.ClienteDto;
import com.api.vendas.model.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("cliente/")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/get")
	public ResponseEntity<List<Cliente>> gelAllVendas(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}
	
	@PostMapping("/post")	
	public ResponseEntity <Object> saveVenda(@RequestBody @Valid ClienteDto clienteDto) {
		var cliente = new Cliente();
		BeanUtils.copyProperties(clienteDto, cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}
}
