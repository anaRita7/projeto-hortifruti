package com.br.backendhortifruti.controllerTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.br.backendhortifruti.controller.ClienteController;
import com.br.backendhortifruti.model.entity.Cliente;

@SpringBootTest
public class ValidadorDocumentoTest {

	@Autowired
	ClienteController clienteController;

	@Test
	public void isCpfValidoTest() {
		Cliente cliente06 = new Cliente(null, "Maria chiquinha", 'F', "243.563.212-60");
		ResponseEntity<Cliente> clienteResponse = clienteController.incluirCliente(cliente06);
		assertEquals(clienteResponse.getBody().getDocumento(), "24356321260");
	}

	@Test
	public void isCnpjValidoTest() {
		Cliente cliente06 = new Cliente(null, "Mercadinho do Joao", 'F', "91.196.444/0001-08");
		ResponseEntity<Cliente> clienteResponse = clienteController.incluirCliente(cliente06);
		assertEquals(clienteResponse.getBody().getDocumento(), "91196444000108");
	}

	@Test
	public void isCpfInvalidoTest() {
		Cliente cliente06 = new Cliente(null, "Maria chiquinha", 'F', "111.111.111-11");
		ResponseEntity<Cliente> clienteResponse = clienteController.incluirCliente(cliente06);
		System.out.println(clienteResponse.toString());
//		assertNull(clienteResponse);
	}

//	@Test
//	public void isCnpjInvalidoTest() {
//		Cliente cliente06 = new Cliente(null, "Mercadinho do Joao", 'F', "77.77.777/0001-77");
//		ResponseEntity<Cliente> clienteResponse = clienteController.incluirCliente(cliente06);
//		assertEquals(clienteResponse.getBody().getDocumento(), "91196444000108");
//	}
}
