package com.api.vendas.model.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vendas.model.Produto;
import com.api.vendas.model.Venda;
import com.api.vendas.model.repository.VendaRepository;

import jakarta.transaction.Transactional;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;

	@Transactional
	public Object save(Venda venda) {
		return vendaRepository.save(venda);
	}

	public Optional<Venda> findByID(UUID id) {
		return vendaRepository.findById(id);
	}

	@Transactional
	public void delete(Venda venda) {
		vendaRepository.delete(venda);
	}

	public List<Venda> findAll() {
		return vendaRepository.findAll();
	}
	
	public Object RealizaVenda(Venda venda) {
	  venda.getItems().forEach(x -> {
	            Produto produto = x.getProduto();
	            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - x.getQuantidadeVenda());
	  	});
	return vendaRepository.save(venda);
	  
	}
	
/*	public void getTotalVenda(List<Venda> totalVenda) {
		
		int TotalQtd = 0;
	    Double TotalPrecoProduto= 0.0;
	    Double troco;
		
		for (Venda venda : totalVenda) {
			
			UUID productId = produto.getIdProduto();
			produtoService.findByID(productId);
			
			TotalPrecoProduto = produto.getPreco() * produto.getQuantidade();
			TotalQtd = produto.getQuantidade() + TotalQtd;
			venda.setQuantidadeProdutos(TotalQtd);
			
			if(venda.getDesconto() == 0) {
				venda.setTotalDaVenda(TotalPrecoProduto);
			} else if(venda.getDesconto() > 0) {
				TotalPrecoProduto = TotalPrecoProduto - venda.getDesconto();
				venda.setTotalDaVenda(TotalPrecoProduto);
			} 
			
			if(venda.getTotalDaVenda() < venda.getValorPago()) {
				troco = venda.getValorPago() - venda.getTotalDaVenda();
				venda.setTroco(troco);
			}
			
			produtoRepository.save(produto);
			
		}	*/
	
	
}
