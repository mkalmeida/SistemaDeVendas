package com.api.vendas.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vendas.model.ItemVenda;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, UUID> {

}
