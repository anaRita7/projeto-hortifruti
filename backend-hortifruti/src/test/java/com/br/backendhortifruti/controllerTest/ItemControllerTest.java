package com.br.backendhortifruti.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.br.backendhortifruti.controller.ItemController;
import com.br.backendhortifruti.model.entity.Item;
import com.br.backendhortifruti.model.entity.Pedido;
import com.br.backendhortifruti.model.entity.Produto;
import com.br.backendhortifruti.model.dto.ItemDTO;
import com.br.backendhortifruti.model.dto.ProdutoDTO;

@SpringBootTest
public class ItemControllerTest {
	
	@Autowired
	ItemController itemController;
	
	@Test
	public void incluirItemTest() {
		Pedido pedido = new Pedido();
		pedido.setId(1);
		
		Produto produto = new Produto();
		produto.setId(3);
		
		Item item = new Item();
		item.setPedido(pedido);
		item.setProduto(produto);
		item.setQuantidadeTotal(123);
		item.setValorTotal(1000);
		
		ResponseEntity<String> itemResponse = itemController.incluirItem(item);
		assertThat(itemResponse.getStatusCodeValue()).isEqualTo(201);
	} 
	
	@Test 
	public void alterarItemTest() {
		Pedido pedido = new Pedido();
		pedido.setId(1);
		
		Produto produto = new Produto();
		produto.setId(5);
		
		Item item = new Item();
		item.setQuantidadeTotal(20);
		item.setValorTotal(80);
		
		ResponseEntity<String> itemResponse = itemController.alterarItem(6, item);
		assertThat(itemResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void excluirItemTest() {
		ResponseEntity<String> itemResponse = itemController.excluirItem(6);
		assertThat(itemResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarItensTest() {
		ResponseEntity<List<ItemDTO>> itemResponse = itemController.consultarItens();
		assertThat(itemResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarItemTest() {
		ResponseEntity<ItemDTO> itemResponse = itemController.consultarItem(7);
		assertThat(itemResponse.getStatusCodeValue()).isEqualTo(200);
	}
}