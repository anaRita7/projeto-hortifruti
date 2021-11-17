package com.br.backendhortifruti.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.br.backendhortifruti.controller.ClienteController;
import com.br.backendhortifruti.model.dto.ClienteDTO;
import com.br.backendhortifruti.model.dto.ClienteIdDTO;
import com.br.backendhortifruti.model.entity.Cliente;

@SpringBootTest
public class ClienteControllerTest {

	@Autowired
	ClienteController clienteController;

	@Test
	public void incluirClientesTeste() {
		Cliente cliente06 = new Cliente(null, "Mercadinho do seu Ze", 'J', "89.698.309/0001-00", "99999999999");
		ResponseEntity<ClienteIdDTO> clienteResponse = clienteController.incluirCliente(cliente06);
		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(201);
	}

	@Test
	public void alterarClienteTeste() {
		Cliente cliente06 = new Cliente(null, "Mercadinho do seu Ze", 'J', "98.456.963/0001-24", "99999999999");
		ResponseEntity<ClienteDTO> clienteResponse = clienteController.alterarCliente(71, cliente06);
		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
	}


	@Test
	public void consultarClientes() {
		ResponseEntity<List<ClienteDTO>> clienteResponse = clienteController.consultarClientes();
		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void consultaDeleteCliente() {
		try {
			ResponseEntity<ClienteDTO> clienteResponse = clienteController.consultarCliente(64);
			if (clienteResponse.getBody().getNome().equals("Mercadinho do seu Ze")) {
				ResponseEntity<String> clienteDeletado = clienteController.excluirCliente(64);
				assertThat(clienteDeletado.getBody().equals("Produto deleted sucessfully!"));
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
