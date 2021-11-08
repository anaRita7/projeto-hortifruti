package com.br.backendhortifruti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.backendhortifruti.model.Produto;
import com.br.backendhortifruti.repository.ProdutoRepository;
import com.br.backendhortifruti.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	private ProdutoRepository produtoRepository;

	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
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

	@Override
	public Produto consultarProduto(int id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent())
			return produto.get();
		return null;
	}

	@Override
	public Produto alterarProduto(Produto produto, int id) {
		Produto existingProduto = null;
		if (produtoRepository.findById(id).isPresent())
			existingProduto = produtoRepository.findById(id).get();
		existingProduto.setNome(produto.getNome());
		existingProduto.setDescricao(produto.getDescricao());
		existingProduto.setUnidadeMedida(produto.getUnidadeMedida());
		existingProduto.setValorUnitario(produto.getValorUnitario());
		existingProduto.setStatus(produto.isStatus());
		
		produtoRepository.save(existingProduto);
		return existingProduto;
	}

	@Override
	public void excluirProduto(int id) {
		produtoRepository.deleteById(id);
	}


	
	
	
	

}
