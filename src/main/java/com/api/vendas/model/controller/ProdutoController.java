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

import com.api.vendas.model.Produto;
import com.api.vendas.model.dto.ProdutoDto;
import com.api.vendas.model.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("produto/")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/get")
	public ResponseEntity<List<Produto>> gelAllProdutos(){
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
	}
	
	@PostMapping("/post")	
	public ResponseEntity <Object> saveVenda(@RequestBody @Valid ProdutoDto produtoDto) {
		var produto = new Produto();
		BeanUtils.copyProperties(produtoDto, produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
	}
	
}
