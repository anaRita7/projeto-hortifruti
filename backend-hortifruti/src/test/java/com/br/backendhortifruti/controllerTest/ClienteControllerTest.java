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
import com.br.backendhortifruti.model.handler.IvalidDocumentException;

@SpringBootTest
public class ClienteControllerTest {
	
	@Autowired
	ClienteController clienteController;

	@Test
	public void incluirClientesTeste() throws IvalidDocumentException {
		Cliente cliente06 = new Cliente();
		cliente06.setNome("Mercadinho do seu Ze");
		cliente06.setTipo('J');
		cliente06.setDocumento("89.698.309/0001-00");
		cliente06.setTelefone("99999999999");

		ResponseEntity<ClienteIdDTO> clienteResponse = clienteController.incluirCliente(cliente06);
		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(201);
	}
	
	@Test
	public void alterarClienteTeste() {
		Cliente cliente06 = new Cliente();
		cliente06.setNome("Mercadinho do seu Ze");
		cliente06.setTipo('J');
		cliente06.setDocumento("98.456.963/0001-24");
		cliente06.setTelefone("99999999999");
		ResponseEntity<ClienteDTO> clienteResponse = clienteController.alterarCliente(71, cliente06);
		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void consultarClientes() {
		ResponseEntity<List<ClienteDTO>> clienteResponse = clienteController.consultarClientes();
		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarClientePorDocumentoTest() {
		ResponseEntity<ClienteIdDTO> clienteResponse = clienteController.consultarClientePorDocumento("605.737.218-04");
		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarClienteTest() {
		 ResponseEntity<ClienteDTO> clienteResponse = clienteController.consultarCliente(1);
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
