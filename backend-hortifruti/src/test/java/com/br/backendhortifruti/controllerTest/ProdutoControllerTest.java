package com.br.backendhortifruti.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.br.backendhortifruti.controller.ProdutoController;
import com.br.backendhortifruti.model.entity.Produto;

@SpringBootTest
public class ProdutoControllerTest {

	@Autowired
	ProdutoController produtoController;
	
	
	@Test
	public void incluirProdutoTest() {
		Produto produto = new Produto();
		produto.setNome("Batata");
		produto.setDescricao("batata branca lavada");
		produto.setUnidadeMedida("kg");
		produto.setValorUnitario(1.23f);
		produto.setStatus(true);
		
		ResponseEntity<String> produtoResponse = produtoController.incluirProduto(produto);
		assertThat(produtoResponse.getStatusCodeValue() == 200);
		
		
	}
}
