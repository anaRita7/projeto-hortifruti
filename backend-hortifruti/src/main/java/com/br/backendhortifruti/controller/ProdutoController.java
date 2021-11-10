package com.br.backendhortifruti.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.backendhortifruti.model.Produto;
import com.br.backendhortifruti.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping("")
	public ResponseEntity<List<Produto>> consultarProdutos() {
		return new ResponseEntity<>(produtoService.consultarProdutos(), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Produto> incluirProduto(@RequestBody Produto produto) {
		return new ResponseEntity<Produto>(produtoService.incluirProduto(produto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> consultarProduto(@PathVariable("id") Integer produtoId) {
		return new ResponseEntity<Produto>(produtoService.consultarProduto(produtoId), HttpStatus.OK);
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<Produto> consultarProdutoPorCodigo(@PathVariable("codigo") Integer codigo) {
		return new ResponseEntity<Produto>(produtoService.consultarProdutoPorCodigo(codigo), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> alterarProduto(@PathVariable("id") Integer produtoId, @RequestBody Produto produto) {
		return new ResponseEntity<Produto>(produtoService.alterarProduto(produto, produtoId), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirProduto(@PathVariable("id") Integer produtoId) {
		produtoService.excluirProduto(produtoId);
		return new ResponseEntity<String>("Produto deleted sucessfully!", HttpStatus.OK);
	}

}
