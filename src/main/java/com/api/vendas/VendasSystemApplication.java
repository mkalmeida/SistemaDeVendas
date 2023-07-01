package com.api.vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages={"com.api.vendas.model", "com.api.vendas.model.controller", "com.api.vendas.model.dto", "com.api.vendas.model.repository", "com.api.vendas.model.service"})
public class VendasSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasSystemApplication.class, args);
	}
	
}
