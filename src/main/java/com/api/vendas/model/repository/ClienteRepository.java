package com.api.vendas.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vendas.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}
