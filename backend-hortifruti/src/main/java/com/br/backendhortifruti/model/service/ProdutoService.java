package com.br.backendhortifruti.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.backendhortifruti.model.entity.Produto;

@Service
public interface ProdutoService {

	Produto incluirProduto(Produto produto);

	List<Produto> consultarProdutos();
	
	List<Produto> consultarProdutosAtivos();

	Produto consultarProduto(Integer id);
	
	Produto consultarProdutoPorCodigo(Integer codigo);
	
	Produto consultarProdutoAtivoPorCodigo(Integer codigo);

	Produto alterarProduto(Produto produto, Integer id);

	void excluirProduto(Integer id);

    Produto alterarStatusProduto(Integer produtoId, boolean status);
}
