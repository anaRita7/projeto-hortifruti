package com.br.backendhortifruti.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.br.backendhortifruti.controller.ProdutoController;
import com.br.backendhortifruti.model.entity.Produto;
import com.br.backendhortifruti.model.dto.ProdutoDTO;

@SpringBootTest
public class ProdutoControllerTest {
	
	@Autowired
	ProdutoController produtoController;
	
	@Test
	public void incluirProdutoTest() {
		Produto p1 = new Produto(null, 9340, "Chuchu", "fonte de potassio", "kg", 3.49, true);
		ResponseEntity<Produto> produtoResponse = produtoController.incluirProduto(p1);
		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(201);
	}
	
	@Test
	public void alterarProdutoTest() {
		Produto p2 = new Produto(null, 1230, "Pimentao", "verde, amarelo e vermelho", "kg", 2.49, true);
		ResponseEntity<Produto> produtoResponse = produtoController.alterarProduto(4, p2);
		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	// TODO: Excluir produto
	
	@Test
	public void consultarProdutoTest() {
		ResponseEntity<List<ProdutoDTO>> produtoResponse = produtoController.consultarProdutos();
		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarProdutoPorCodigoTest() {
		ResponseEntity<ProdutoDTO> produtoResponse = produtoController.consultarProdutoPorCodigo(1);
		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	// TODO: Consultar produto
	
	// TODO: Consultar produtos ativos
		
	// TODO: Consultar produtos ativos por codigo
		
}
