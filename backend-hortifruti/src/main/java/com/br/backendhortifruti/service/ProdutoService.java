package com.br.backendhortifruti.service;

import java.util.List;

import com.br.backendhortifruti.model.Produto;

public interface ProdutoService {

	Produto incluirProduto(Produto produto);

	List<Produto> consultarProdutos();

	Produto consultarProduto(int id);

	Produto alterarProduto(Produto produto, int id);

	void excluirProduto(int id);
}
