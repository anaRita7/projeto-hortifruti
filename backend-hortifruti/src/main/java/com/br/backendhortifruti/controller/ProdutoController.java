package com.br.backendhortifruti.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
import com.br.backendhortifruti.model.dto.ProdutoForItemDTO;
import com.br.backendhortifruti.model.entity.Produto;
import com.br.backendhortifruti.model.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<PageImpl<ProdutoDTO>> consultarProdutos(Pageable pageable) {
		Page<Produto> page = produtoService.consultarProdutos(pageable);
		PageImpl<ProdutoDTO> pageDTO = new PageImpl<>(ProdutoDTO.converterList(page.getContent()), pageable, page.getTotalElements());
		return new ResponseEntity<>(pageDTO, HttpStatus.OK);
	}


	@GetMapping("/ativos")
	public ResponseEntity<PageImpl<ProdutoAtivoDTO>> consultarProdutosAtivosPage(Pageable pageable) {
		Page<Produto> page = produtoService.consultarProdutos(pageable);
		PageImpl<ProdutoAtivoDTO> pageDTO = new PageImpl<>(ProdutoAtivoDTO.converterList(page.getContent()), pageable, page.getTotalElements());
		return new ResponseEntity<>(pageDTO, HttpStatus.OK);
	}

	@GetMapping("/ativos/codigo/{codigo}")
	public ResponseEntity<ProdutoAtivoDTO> consultarProdutoAtivoPorCodigo(@PathVariable("codigo") Integer codigo) {
		try{
			Produto produto = produtoService.consultarProdutoAtivoPorCodigo(codigo);
			return new ResponseEntity<ProdutoAtivoDTO>(ProdutoAtivoDTO.converter(produto), HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
	}

	@PostMapping
	public ResponseEntity<String> incluirProduto(@RequestBody Produto produto) {
		Produto produtoResponse = produtoService.incluirProduto(produto);
		if(produtoResponse == null) {
			return new ResponseEntity<>("Falha ao criar o produto!", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> consultarProduto(@PathVariable("id") Integer produtoId) {
		try{
			Produto produto = produtoService.consultarProduto(produtoId);
			return new ResponseEntity<ProdutoDTO>(ProdutoDTO.converter(produto), HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<ProdutoForItemDTO> consultarProdutoPorCodigo(@PathVariable("codigo") Integer codigo) {
		try{
			Produto produto = produtoService.consultarProdutoPorCodigo(codigo);
			return new ResponseEntity<ProdutoForItemDTO>(ProdutoForItemDTO.converter(produto), HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> alterarProduto(@PathVariable("id") Integer produtoId, @RequestBody Produto produto) {
		try{
			produtoService.alterarProduto(produto, produtoId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirProduto(@PathVariable("id") Integer produtoId) {
		try {
			produtoService.excluirProduto(produtoId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>("Falha ao deletar o produto!", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<ProdutoDTO> alterarStatusProduto(@PathVariable("id") Integer produtoId, @RequestBody boolean status){
		try{
			Produto produtoResponse = produtoService.alterarStatusProduto(produtoId, status);
			return new ResponseEntity<ProdutoDTO>(ProdutoDTO.converter(produtoResponse), HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
	}
}