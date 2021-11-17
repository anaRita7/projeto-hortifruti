package com.br.backendhortifruti.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.br.backendhortifruti.controller.PedidoController;
import com.br.backendhortifruti.model.entity.Cliente;
import com.br.backendhortifruti.model.entity.Endereco;
import com.br.backendhortifruti.model.entity.Pedido;

@SpringBootTest
public class PedidoControllerTest {

	@Autowired
	PedidoController pedidoController;

	@Test
	public void incluirPedidoTeste() {
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
		assertThat(pedidoResponse.getStatusCodeValue() == 200);
	}
	
	@Test
	public void incluirPedidoFalhaTeste() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		Endereco endereco = new Endereco();
		endereco.setId(1);

		Pedido pedido01 = new Pedido();
		pedido01.setDataHora(LocalDateTime.now());
		pedido01.setCliente(cliente);
		pedido01.setEndereco(endereco);
		pedido01.setCodigo(3015);

		ResponseEntity<String> pedidoResponse = pedidoController.incluirPedido(pedido01);
		assertThat(pedidoResponse.getStatusCodeValue() == 422);
	}
}
