package com.br.backendhortifruti.model.service;

import java.util.List;

import com.br.backendhortifruti.model.entity.Produto;

public interface ProdutoService {

	Produto incluirProduto(Produto produto);

	List<Produto> consultarProdutos();

	Produto consultarProduto(Integer id);
	
	Produto consultarProdutoPorCodigo(Integer codigo);

	Produto alterarProduto(Produto produto, Integer id);

	void excluirProduto(Integer id);
}
