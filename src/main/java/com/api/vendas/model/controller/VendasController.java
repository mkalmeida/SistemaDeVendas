package com.api.vendas.model.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

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
import com.api.vendas.model.Produto;
import com.api.vendas.model.Venda;
import com.api.vendas.model.dto.VendaDto;
import com.api.vendas.model.service.VendaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("venda/")
public class VendasController  {
	
	@Autowired
	private VendaService vendaService;

	private Produto produto;
	
	@GetMapping("/get")
	public ResponseEntity<List<Venda>> gelAllVendas(){
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.findAll());
	}
	
	@PostMapping("/post")	
	public ResponseEntity <Object> saveVenda(@RequestBody @Valid VendaDto vendaDto) {
		var venda = new Venda();
		BeanUtils.copyProperties(vendaDto, venda);
		venda.setItens(produto.getItens());
		venda.setDataHoraCriacao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.save(venda));
	}
	
	//@GetMapping("get/{id}")
	/*public ResponseEntity<Object> getOneVenda(@PathVariable(value="id") UUID id){
		Optional <Produto> prod = produtoService.findByID(id);
		Produto produto = new Produto();
		produto.getNome();
		produto.getPreco();
		ItensCompra.add(produto);
		return ResponseEntity.status(HttpStatus.OK).body(ItensCompra);
	}*/

}
