package com.br.backendhortifruti.model.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.br.backendhortifruti.model.entity.Produto;
import com.br.backendhortifruti.model.repository.ProdutoRepository;
import com.br.backendhortifruti.model.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private ProdutoRepository produtoRepository;
	
	Random random = new Random();

	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Override
	public Produto incluirProduto(Produto produto) {
		if(produto.getCodigo() == null) {
			Integer codigoGerado = (random.nextInt(10000) + 1000);
			if (consultarProdutoPorCodigo(codigoGerado) == null) {
				produto.setCodigo(codigoGerado);
				return produtoRepository.save(produto);
			}
		}
		return null;
	}

	@Override
	public List<Produto> consultarProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto consultarProduto(Integer id) {
		return produtoRepository.findById(id).get();
	}

	@Override
	public Produto alterarProduto(Produto produto, Integer id) {
		Produto existingProduto = produtoRepository.findById(id).get();
		existingProduto.setNome(produto.getNome());
		existingProduto.setDescricao(produto.getDescricao());
		existingProduto.setUnidadeMedida(produto.getUnidadeMedida());
		existingProduto.setValorUnitario(produto.getValorUnitario());
		existingProduto.setStatus(produto.isStatus());

		produtoRepository.save(existingProduto);
		return existingProduto;
	}

	@Override
	public void excluirProduto(Integer id) {
		produtoRepository.deleteById(id);
	}

	@Override
	public Produto consultarProdutoPorCodigo(Integer codigo) {
		return produtoRepository.findByCodigo(codigo).get();
	}

	@Override
	public List<Produto> consultarProdutosAtivos() {
		return produtoRepository.findByStatusTrue();
	}

	@Override
	public Produto consultarProdutoAtivoPorCodigo(Integer codigo) {
		return produtoRepository.findByStatusAndCodigo(true, codigo).get();
	}

	@Override
	public Produto alterarStatusProduto(Integer produtoId, boolean status) {
		Produto produto = produtoRepository.findById(produtoId).get();
		produto.setStatus(status);
		return produtoRepository.save(produto);
	}

}
