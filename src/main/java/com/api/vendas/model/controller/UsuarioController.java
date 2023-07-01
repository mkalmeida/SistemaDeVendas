package com.api.vendas.model.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vendas.model.Usuario;
import com.api.vendas.model.dto.UsuarioDto;
import com.api.vendas.model.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario/")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/get")
	public ResponseEntity<List<Usuario>> gelAllVendas(){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
	}
	
	@PostMapping("/post")	
	public ResponseEntity <Object> saveVenda(@RequestBody @Valid UsuarioDto usuarioDto) {
		var usuario = new Usuario();
		BeanUtils.copyProperties(usuarioDto, usuario);
		usuario.setUltimoLogin(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
}
