package com.br.backendhortifruti.mockitoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

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

import com.br.backendhortifruti.model.entity.Item;
import com.br.backendhortifruti.model.entity.Pedido;
import com.br.backendhortifruti.model.entity.Produto;
import com.br.backendhortifruti.model.repository.ItemRepository;
import com.br.backendhortifruti.model.service.impl.ItemServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ItemMockTest {
	
	@Mock
	private ItemRepository itemRepository;
	
	@InjectMocks
	private ItemServiceImpl itemServiceImpl;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@DisplayName("Cadastrar um novo item")
	@Test
	public void incluirItemMockTest() {
		Pedido pedido = new Pedido();
		pedido.setId(1);
		
		Produto produto = new Produto();
		produto.setId(1);
		
		Item item = new Item();
		
		when(itemRepository.save(Mockito.any(Item.class))).thenReturn(item);
		
		item.setPedido(pedido);
		item.setProduto(produto);
		item.setQuantidadeTotal(123);
		item.setValorTotal(1000);
		
		Item itemResponse = itemServiceImpl.incluirItem(item);
		assertThat(itemResponse.getPedido().getId() == 1);
		assertThat(itemResponse.getProduto().getId() == 1);
		assertThat(itemResponse.getQuantidadeTotal() == 123);
		assertThat(itemResponse.getValorTotal() == 1000);
	}
	
	@DisplayName("Alterar um item")
	@Test
	public void alterarItemMockTest() {
		Pedido pedido = new Pedido();
		pedido.setId(2);
		
		Produto produto = new Produto();
		produto.setId(2);
		
		Item item = new Item();
		
		when(itemRepository.findById(1)).thenReturn(Optional.of(item));
		when(itemRepository.save(Mockito.any(Item.class))).thenReturn(item);
		
		item.setPedido(pedido);
		item.setProduto(produto);
		item.setQuantidadeTotal(568);
		item.setValorTotal(1000);
		
		Item itemResponse = itemServiceImpl.incluirItem(item);
		assertThat(itemResponse.getPedido().getId() == 2);
		assertThat(itemResponse.getProduto().getId() == 2);
		assertThat(itemResponse.getQuantidadeTotal() == 568);
		assertThat(itemResponse.getValorTotal() == 1000);
	}
	
	// TODO: consultar todos os itens
	
	@DisplayName("Consultar um item")
	@Test
	public void consultarItemMockTest() {
		Item item = new Item();
		item.setId(1);
		
		when(itemRepository.findById(1)).thenReturn(Optional.of(item));
		itemServiceImpl.consultarItem(1);
		assertThat(item.getId() == 1);
	}
	
	// TODO: excluir item
}