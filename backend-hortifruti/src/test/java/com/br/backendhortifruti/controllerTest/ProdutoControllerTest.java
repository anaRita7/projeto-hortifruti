package com.br.backendhortifruti.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.br.backendhortifruti.controller.ProdutoController;
import com.br.backendhortifruti.model.dto.ProdutoAtivoDTO;
import com.br.backendhortifruti.model.dto.ProdutoDTO;
import com.br.backendhortifruti.model.dto.ProdutoIdDTO;
import com.br.backendhortifruti.model.entity.Produto;

@SpringBootTest
public class ProdutoControllerTest {

	@Autowired
	ProdutoController produtoController;
	
//	@Test
//	public void incluirProdutoTest() {
//		Produto p1 = new Produto();
//		p1.setNome("Chuchu");
//		p1.setDescricao("fonte de potassio");
//		p1.setUnidadeMedida("kg");
//		p1.setValorUnitario(3.49);
//		p1.setStatus(true);
//
//		ResponseEntity<String> produtoResponse = produtoController.incluirProduto(p1);
//		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(201);
//	}
	
	@Test
	public void alterarProdutoTest() {
		Produto p2 = new Produto();
		p2.setNome("Pimentao");
		p2.setDescricao("verde, amarelo e vermelho");
		p2.setUnidadeMedida("kg");
		p2.setValorUnitario(2.49);
		p2.setStatus(true);
		
		ResponseEntity<String> produtoResponse = produtoController.alterarProduto(4, p2);
		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void excluirProdutoTest() {
		ResponseEntity<String> produtoResponse = produtoController.excluirProduto(4);
		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
//	@Test
//	public void consultarProdutosTest() {
//		ResponseEntity<List<ProdutoDTO>> produtoResponse = produtoController.consultarProdutos();
//		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
//	}
	
	@Test
	public void consultarProdutoPorCodigoTest() {
		 ResponseEntity<ProdutoIdDTO> produtoResponse = produtoController.consultarProdutoPorCodigo(4323);
		 assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarProdutoTest() {
		 ResponseEntity<ProdutoDTO> produtoResponse = produtoController.consultarProduto(1);
		 assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
//	@Test
//	public void consultarProdutosAtivosTest() {
//		ResponseEntity<List<ProdutoAtivoDTO>> produtoResponse = produtoController.consultarProdutosAtivos();
//		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
//	}
		
	@Test
	public void consultarProdutosAtivosPorCodigoTest() {
		ResponseEntity<ProdutoAtivoDTO> produtoResponse = produtoController.consultarProdutoAtivoPorCodigo(8861);
		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void alterarStatusProdutoTest() {
		ResponseEntity<ProdutoDTO> produtoResponse = produtoController.alterarStatusProduto(1, false);
		assertThat(produtoResponse.getStatusCodeValue()).isEqualTo(200);
	}
}