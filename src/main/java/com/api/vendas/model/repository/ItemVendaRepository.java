package com.api.vendas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.vendas.model.ItemVenda;
import com.api.vendas.model.ItensVendaPK;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, ItensVendaPK> {

}
