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

import com.br.backendhortifruti.model.dto.ProdutoAtivoDTO;
import com.br.backendhortifruti.model.dto.ProdutoDTO;
import com.br.backendhortifruti.model.dto.ProdutoIdDTO;
import com.br.backendhortifruti.model.entity.Produto;
import com.br.backendhortifruti.model.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping("")
	public ResponseEntity<List<ProdutoDTO>> consultarProdutos() {
		List<Produto> produtos = produtoService.consultarProdutos();
		return new ResponseEntity<>(ProdutoDTO.converterList(produtos), HttpStatus.OK);
	}
	
	@GetMapping("/ativos")
	public ResponseEntity<List<ProdutoAtivoDTO>> consultarProdutosAtivos() {
		List<Produto> produtos = produtoService.consultarProdutosAtivos();
		return new ResponseEntity<>(ProdutoAtivoDTO.converterList(produtos), HttpStatus.OK);
	}
	
	@GetMapping("/ativos/codigo/{codigo}")
	public ResponseEntity<ProdutoAtivoDTO> consultarProdutoAtivoPorCodigo(@PathVariable("codigo") Integer codigo) {
		Produto produto = produtoService.consultarProdutoAtivoPorCodigo(codigo);
		return new ResponseEntity<ProdutoAtivoDTO>(ProdutoAtivoDTO.converter(produto), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<String> incluirProduto(@RequestBody Produto produto) {
		Produto produtoResponse = produtoService.incluirProduto(produto);
		if(produtoResponse == null) {
			return new ResponseEntity<String>("Falha ao criar o produto!", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<String>("Produto criado com sucesso!", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> consultarProduto(@PathVariable("id") Integer produtoId) {
		Produto produto = produtoService.consultarProduto(produtoId);
		return new ResponseEntity<ProdutoDTO>(ProdutoDTO.converter(produto), HttpStatus.OK);
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<ProdutoIdDTO> consultarProdutoPorCodigo(@PathVariable("codigo") Integer codigo) {
		Produto produto = produtoService.consultarProdutoPorCodigo(codigo);
		return new ResponseEntity<ProdutoIdDTO>(ProdutoIdDTO.converter(produto), HttpStatus.OK);
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<String> alterarProduto(@PathVariable("id") Integer produtoId, @RequestBody Produto produto) {
		produtoService.alterarProduto(produto, produtoId);
		return new ResponseEntity<String>("Produto alterado com sucesso!",HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirProduto(@PathVariable("id") Integer produtoId) {
		produtoService.excluirProduto(produtoId);
		return new ResponseEntity<String>("Produto deletado com sucesso!", HttpStatus.OK);
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<ProdutoDTO> alterarStatusProduto(@PathVariable("id") Integer produtoId, @RequestBody boolean status){
		Produto produtoResponse = produtoService.alterarStatusProduto(produtoId, status);
		return new ResponseEntity<ProdutoDTO>(ProdutoDTO.converter(produtoResponse), HttpStatus.OK);
	}
}
