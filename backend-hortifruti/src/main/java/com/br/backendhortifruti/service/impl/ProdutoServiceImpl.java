package com.br.backendhortifruti.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.backendhortifruti.model.Produto;
import com.br.backendhortifruti.repository.ProdutoRepository;
import com.br.backendhortifruti.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	private ProdutoRepository produtoRepository;

	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}

	@Override
	public Produto incluirProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public List<Produto> consultarProdutos() {
		return produtoRepository.findAll();
	}
	
	
	
	

}
