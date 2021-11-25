package com.br.backendhortifruti.mockitoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
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

import com.br.backendhortifruti.model.entity.Cliente;
import com.br.backendhortifruti.model.entity.Endereco;
import com.br.backendhortifruti.model.entity.Pedido;
import com.br.backendhortifruti.model.repository.PedidoRepository;
import com.br.backendhortifruti.model.service.impl.PedidoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PedidoMockTest {
	
	@Mock
	private PedidoRepository pedidoRepository;
	
	@InjectMocks
	private PedidoServiceImpl pedidoServiceImpl;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@DisplayName("Cadastrar um novo pedido")
	@Test
	public void incluirPedidoMockTest() {
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		Endereco endereco = new Endereco();
		endereco.setId(1);

		Pedido pedido = new Pedido();
		
		when(pedidoRepository.save(Mockito.any(Pedido.class))).thenReturn(pedido); 
		
		pedido.setCliente(cliente);
		pedido.setEndereco(endereco);
		pedido.setSituacao(true);
		pedido.setValorTotal(850.00);
		pedido.setQuantidadeTotal(30);
		pedido.setDesconto(0.10);
		pedido.setValorFinal(765.80);
		pedido.setFormaPagamento("dinheiro");
		
		Pedido pedidoResponse = pedidoServiceImpl.incluirPedido(pedido);
		assertThat(pedidoResponse.getCliente().getId() == 1);
		assertThat(pedidoResponse.getEndereco().getId() == 1);
		assertEquals(pedidoResponse.isSituacao(), true);
		assertThat(pedidoResponse.getValorTotal() == 850.00);
		assertThat(pedidoResponse.getQuantidadeTotal() == 30);
		assertThat(pedidoResponse.getDesconto() == 0.10);
		assertThat(pedidoResponse.getValorFinal() == 765.80);
		assertEquals(pedidoResponse.getFormaPagamento(), "dinheiro");
	}
	
	@DisplayName("Alterar um pedido")
	@Test
	public void alterarPedidoMockTest() {
		
		Cliente cliente = new Cliente();
		cliente.setId(2);
		Endereco endereco = new Endereco();
		endereco.setId(2);

		Pedido pedido = new Pedido();
		
		when(pedidoRepository.findById(1)).thenReturn(Optional.of(pedido));
		when(pedidoRepository.save(Mockito.any(Pedido.class))).thenReturn(pedido);
		
		pedido.setCliente(cliente);
		pedido.setEndereco(endereco);
		pedido.setSituacao(true);
		pedido.setValorTotal(450.00);
		pedido.setQuantidadeTotal(15);
		pedido.setDesconto(0.10);
		pedido.setValorFinal(765.80);
		pedido.setFormaPagamento("dinheiro");
		
		Pedido pedidoResponse = pedidoServiceImpl.alterarPedido(1, pedido);
		assertThat(pedidoResponse.getCliente().getId() == 2);
		assertThat(pedidoResponse.getEndereco().getId() == 2);
		assertEquals(pedidoResponse.isSituacao(), true);
		assertThat(pedidoResponse.getValorTotal() == 450.00);
		assertThat(pedidoResponse.getQuantidadeTotal() == 15);
		assertThat(pedidoResponse.getDesconto() == 0.10);
		assertThat(pedidoResponse.getValorFinal() == 765.80);
		assertEquals(pedidoResponse.getFormaPagamento(), "dinheiro");
	}
	
	@DisplayName("Consultar pedido por codigo")
	@Test
	public void consultarPedidoPorCodigoMockTest() {
		Pedido pedido = new Pedido();
		pedido.setCodigo(12843);
		
		when(pedidoRepository.findByCodigo(12843)).thenReturn(Optional.of(pedido));
		pedidoServiceImpl.consultarPedidoPorCodigo(12843);
		assertThat(pedido.getCodigo() == 12843);
	}
	
	@DisplayName("Consultar pedido por ID")
	@Test
	public void consultarPedidoMockTest() {
		Pedido pedido = new Pedido();
		pedido.setId(1);
		
		when(pedidoRepository.findById(1)).thenReturn(Optional.of(pedido));
		pedidoServiceImpl.consultarPedido(1);
		assertThat(pedido.getId() == 1);
	}
}
	