package com.br.backendhortifruti.service;

import java.util.List;

import com.br.backendhortifruti.model.Produto;

public interface ProdutoService {
	
	Produto incluirProduto(Produto produto);
	List<Produto> consultarProdutos();
	Produto consultarProduto (int id);
}
