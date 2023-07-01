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

import com.api.vendas.model.Categoria;
import com.api.vendas.model.dto.CategoriaDto;
import com.api.vendas.model.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("categoria/")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/get")
	public ResponseEntity<List<Categoria>> gelAllCategorias(){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
	}
	
	@PostMapping("/post")	
	public ResponseEntity <Object> saveCategoria(@RequestBody @Valid CategoriaDto categoriaDto) {
		var categoria = new Categoria();
		BeanUtils.copyProperties(categoriaDto, categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
	}
}
