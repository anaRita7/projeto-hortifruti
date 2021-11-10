package com.br.backendhortifruti.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.br.backendhortifruti.controller.ClienteController;
import com.br.backendhortifruti.model.entity.Cliente;

@SpringBootTest
public class ClienteControllerTest {

	@Autowired
	ClienteController clienteController;
	
	@Test
	public void incluirClientes() {
		Cliente cliente06 = new Cliente(null, "Mercadinho do seu Ze", 'J', "XX. XXX. XXX/0001-XX");
		ResponseEntity<Cliente> clienteResponse = clienteController.incluirCliente(cliente06);
		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void alterarCliente() {
		Cliente cliente06 = new Cliente(null, "Mercadinho do seu Ze", 'J', "98.456.963/0001-24");
		ResponseEntity<Cliente> clienteResponse = clienteController.alterarCliente(5, cliente06);
		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarCliente() {
		ResponseEntity<Cliente> clienteResponse = clienteController.consultarCliente(5);
		assertThat(clienteResponse.getBody().getNome().equals("Mercadinho do seu Ze"));
	}
	
	@Test
	public void consultarClientes() {
		ResponseEntity<List<Cliente>> clienteResponse = clienteController.consultarClientes();
		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void deleteCliente() {
		ResponseEntity<String> clienteResponse = clienteController.excluirCliente(9);
		assertThat(clienteResponse.getBody().equals("Produto deleted sucessfully!"));
	}
	
}
