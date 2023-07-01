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

import com.api.vendas.model.ItemVenda;
import com.api.vendas.model.dto.ItemVendaDTO;
import com.api.vendas.model.service.ItemVendaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("itemvenda/")
public class ItemVendaController {

	@Autowired
	private ItemVendaService itemVendaService;
	
	@GetMapping("/get")
	public ResponseEntity<List<ItemVenda>> gelAllItens(){
		return ResponseEntity.status(HttpStatus.OK).body(itemVendaService.findAll());
	}
	
	@PostMapping("/post")	
	public ResponseEntity <Object> saveVenda(@RequestBody @Valid ItemVendaDTO itemVendaDto) {
		var itemVenda = new ItemVenda();
		BeanUtils.copyProperties(itemVendaDto, itemVenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemVendaService.save(itemVenda));
	}
}