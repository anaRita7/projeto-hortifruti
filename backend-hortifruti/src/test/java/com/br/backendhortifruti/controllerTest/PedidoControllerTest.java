package com.br.backendhortifruti.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.br.backendhortifruti.controller.PedidoController;
import com.br.backendhortifruti.model.dto.PedidoDTO;
import com.br.backendhortifruti.model.dto.PedidoForListDTO;
import com.br.backendhortifruti.model.entity.Pedido;
import com.br.backendhortifruti.model.entity.Cliente;
import com.br.backendhortifruti.model.entity.Endereco;

@SpringBootTest
public class PedidoControllerTest {

	@Autowired
	PedidoController pedidoController;

	@Test
	public void incluirPedidoTest() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		Endereco endereco = new Endereco();
		endereco.setId(1);

		Pedido pedido01 = new Pedido();
		pedido01.setDataHora(LocalDateTime.now());
		pedido01.setCliente(cliente);
		pedido01.setEndereco(endereco);
		pedido01.setSituacao(true);
		pedido01.setValorTotal(720.00);
		pedido01.setQuantidadeTotal(26);
		pedido01.setDesconto(0.10);
		pedido01.setValorFinal(712.80);
		pedido01.setFormaPagamento("dinheiro");

		ResponseEntity<String> pedidoResponse = pedidoController.incluirPedido(pedido01);
		assertThat(pedidoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void incluirPedidoFailTest() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		Endereco endereco = new Endereco();
		endereco.setId(1);

		Pedido pedido = new Pedido();
		pedido.setDataHora(LocalDateTime.now());
		pedido.setCliente(cliente);
		pedido.setEndereco(endereco);
		pedido.setCodigo(3015);

		ResponseEntity<String> pedidoResponse = pedidoController.incluirPedido(pedido);
		assertThat(pedidoResponse.getStatusCodeValue()).isEqualTo(422);
	}
	
	@Test
	public void alterarPedidoTeste() {
		Cliente cliente = new Cliente();
		cliente.setId(3);
		Endereco endereco = new Endereco();
		endereco.setId(1);

		Pedido pedido = new Pedido();
		pedido.setDataHora(LocalDateTime.now());
		pedido.setCliente(cliente);
		pedido.setEndereco(endereco);
		pedido.setSituacao(true);
		pedido.setValorTotal(190.00);
		pedido.setQuantidadeTotal(13);
		pedido.setDesconto(0.25);
		pedido.setValorFinal(899.90);
		pedido.setFormaPagamento("debito");

		ResponseEntity<String> pedidoResponse = pedidoController.alterarPedido(1, pedido);
		assertThat(pedidoResponse.getStatusCodeValue() == 200);
	}
	
	@Test
	public void excluirPedidoTest() {
		ResponseEntity<String> pedidoResponse = pedidoController.excluirPedido(1);
		assertThat(pedidoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarPedidosTest() {
		ResponseEntity<List<PedidoForListDTO>> pedidoResponse = pedidoController.consultarPedidos();
		assertThat(pedidoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarPedidoTest() {
		ResponseEntity<PedidoDTO> pedidoResponse = pedidoController.consultarPedido(1);
		assertThat(pedidoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarPedidoPorCodigoTest() {
		ResponseEntity<PedidoDTO> pedidoResponse = pedidoController.consultarPedidoPorCodigo(123);
		assertThat(pedidoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	// TODO: consultarProdutosAtivos()
	
	// TODO: consultarProdutosInativos()
}
