package com.br.backendhortifruti.mockitoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.br.backendhortifruti.model.entity.Produto;
import com.br.backendhortifruti.model.repository.ProdutoRepository;
import com.br.backendhortifruti.model.service.impl.ProdutoServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class ProdutoMockTest {
	
	@Mock
	private ProdutoRepository produtoRepository;
	
	@InjectMocks
	private ProdutoServiceImpl produtoServiceImpl;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@DisplayName("Cadastrar um novo produto")
	@Test
	public void incluirProdutoMockTest() {
		Produto produto = new Produto();
		
		when(produtoRepository.save(Mockito.any(Produto.class))).thenReturn(produto);
		
		produto.setNome("Chuchu");
		produto.setDescricao("fonte de potassio");
		produto.setUnidadeMedida("kg");
		produto.setValorUnitario(3.49);
		produto.setStatus(true);
		
		Produto produtoResponse = produtoServiceImpl.incluirProduto(produto);
		assertEquals(produtoResponse.getNome(), "Chuchu");
		assertEquals(produtoResponse.getDescricao(), "fonte de potassio");
		assertEquals(produtoResponse.getUnidadeMedida(), "kg");
		assertThat(produtoResponse.getValorUnitario() == 3.49);
		assertThat(produtoResponse.isStatus() == true);
	}
	
	@DisplayName("Alterar um produto")
	@Test
	public void alterarProdutoMockTest() {
		Produto produto = new Produto();
		
		when(produtoRepository.findById(1)).thenReturn(Optional.of(produto)); 
		when(produtoRepository.save(Mockito.any(Produto.class))).thenReturn(produto);
		
		produto.setNome("Batata baroa");
		produto.setDescricao("Otima guarnicao");
		produto.setUnidadeMedida("Kg");
		produto.setValorUnitario(5.49);
		produto.setStatus(true);
		
		Produto produtoResponse = produtoServiceImpl.alterarProduto(produto, 1);
		assertEquals(produtoResponse.getNome(), "Batata baroa");
		assertEquals(produtoResponse.getDescricao(), "Otima guarnicao");
		assertEquals(produtoResponse.getUnidadeMedida(), "Kg");
		assertThat(produtoResponse.getValorUnitario() == 5.49);
		assertThat(produtoResponse.isStatus() == true);
	}
	
	/*@DisplayName("Consultar produtos")
	@Test
	public void consultarProdutosMockTest() {
		List<Produto> listaProdutos = new ArrayList<Produto>();
				
		when(produtoRepository.findAll()).thenReturn(listaProdutos);
		
		Produto p1 = new Produto();
		p1.setNome("Chuchu");
		p1.setDescricao("fonte de potassio");
		p1.setUnidadeMedida("kg");
		p1.setValorUnitario(3.49);
		p1.setStatus(true);
		listaProdutos.add(p1);
		
		Produto p2 = new Produto();
		p2.setNome("Batata baroa");
		p2.setDescricao("Otima guarnicao");
		p2.setUnidadeMedida("Kg");
		p2.setValorUnitario(5.49);
		p2.setStatus(true);
		listaProdutos.add(p2);
		
		Page<Produto> produtoResponse = produtoServiceImpl.consultarProdutos();
		assertNotNull(produtoResponse);
		assertThat(listaProdutos.size() == 2);
	}*/
	
	@DisplayName("Consultar produto por id")
	@Test
	public void consultarProdutoPorIdMockTest() {
		Produto produto = new Produto();
		produto.setId(1);
		
		when(produtoRepository.findById(1)).thenReturn(Optional.of(produto));
		Produto produtoResponse = produtoServiceImpl.consultarProduto(1);
		assertNotNull(produtoResponse);
		assertThat(produto.getId() == 1);
	}
	
	@DisplayName("Consultar produto por codigo")
	@Test
	public void consultarProdutoPorCodigoMockTest() {
		Produto produto = new Produto();
		produto.setCodigo(1234);
		
		when(produtoRepository.findByCodigo(1234)).thenReturn(Optional.of(produto));
		Produto produtoResponse = produtoServiceImpl.consultarProdutoPorCodigo(1234);
		assertNotNull(produtoResponse);
		assertThat(produto.getCodigo() == 1234);
	}
	
	@DisplayName("Consultar produtos ativos")
	@Test
	public void consultarProdutosAtivosMockTest() {
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		Produto p1 = new Produto();
		p1.setStatus(true);
		listaProdutos.add(p1);
		
		Produto p2 = new Produto();
		p2.setStatus(true);
		listaProdutos.add(p2);
		
		when(produtoRepository.findByStatusTrue()).thenReturn(listaProdutos);
		List<Produto> produtoResponse = produtoServiceImpl.consultarProdutosAtivos();
		assertNotNull(produtoResponse);
		assertThat(listaProdutos.size() == 2);
		assertThat(p1.isStatus() == true);
		assertThat(p2.isStatus() == true);
	}
	
	@DisplayName("Consultar produto ativo por codigo")
	@Test
	public void consultarProdutoAtivoPorCodigoMockTest() {
		Produto produto = new Produto();
		produto.setCodigo(9283);
		produto.setStatus(true);
		
		when(produtoRepository.findByCodigo(1234)).thenReturn(Optional.of(produto));
		Produto produtoResponse = produtoServiceImpl.consultarProdutoAtivoPorCodigo(9283);
		assertNotNull(produtoResponse);
		assertThat(produto.getCodigo() == 9283);
		assertThat(produto.isStatus() == true);
	}
	
	@DisplayName("Altera o status do produto")
	@Test
	public void alterarStatusProdutoMockTest() {
		Produto produto = new Produto();
		produto.setId(1);
		produto.setStatus(true);
		
		when(produtoRepository.findById(1)).thenReturn(Optional.of(produto));
		produtoServiceImpl.alterarStatusProduto(1, false);
		assertThat(produto.isStatus() == false);
	}
}
