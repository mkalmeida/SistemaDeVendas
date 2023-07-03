package com.api.vendas.model.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
import com.api.vendas.model.Venda;
import com.api.vendas.model.dto.VendaDto;
import com.api.vendas.model.service.ItemVendaService;
import com.api.vendas.model.service.VendaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("venda/")
public class VendasController  {
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private ItemVendaService itemVendaService;
	
	@GetMapping("/get")
	public ResponseEntity<List<Venda>> gelAllVendas(){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.findAll());
	}
	
	@PostMapping("/post")	
	public ResponseEntity <Object> saveVenda(@RequestBody @Valid VendaDto vendaDto, ItemVenda itemVenda) {
		var venda = new Venda();
		BeanUtils.copyProperties(vendaDto, venda);
		venda.setValorTotal(5.3);
		venda.setValorPago(5.4);
		venda.setDataHoraCriacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.save(venda, itemVenda));
	}
	
	/*@PostMapping("/post/teste")	
	public ResponseEntity <Object> RealizaVenda(@RequestBody @Valid VendaDto vendaDto) {
		var venda = new Venda();
		BeanUtils.copyProperties(vendaDto, venda);
		venda.setValorTotal(5.3);
		venda.setValorPago(5.4);
		venda.setDataHoraCriacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.RealizaVenda(venda));
	}*/
	

}
