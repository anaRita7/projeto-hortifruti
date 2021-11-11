package com.br.backendhortifruti.controllerTest;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteControllerTest {

//	@Autowired
//	ClienteController clienteController;
//
//	@Test
//	public void incluirClientesTeste() {
//		Cliente cliente06 = new Cliente(null, "Mercadinho do seu Ze", 'J', "XX. XXX. XXX/0001-XX");
//		ResponseEntity<Cliente> clienteResponse = clienteController.incluirCliente(cliente06);
//		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
//	}
//
//	@Test
//	public void alterarClienteTeste() {
//		Cliente cliente06 = new Cliente(null, "Mercadinho do seu Ze", 'J', "98.456.963/0001-24");
//		ResponseEntity<Cliente> clienteResponse = clienteController.alterarCliente(5, cliente06);
//		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
//	}
//
//
//	@Test
//	public void consultarClientes() {
//		ResponseEntity<List<ClienteDTO>> clienteResponse = clienteController.consultarClientes();
//		assertThat(clienteResponse.getStatusCodeValue()).isEqualTo(200);
//	}
//
//	@Test
//	public void consultaDeleteCliente() {
//		try {
//			ResponseEntity<ClienteDTO> clienteResponse = clienteController.consultarCliente(28);
//			assertThat(clienteResponse.getBody().getNome().equals("Mercadinho do seu Ze"));
//			if (clienteResponse.getBody().getNome().equals("Mercadinho do seu Ze")) {
//				ResponseEntity<String> clienteDeletado = clienteController.excluirCliente(28);
//				assertThat(clienteDeletado.getBody().equals("Produto deleted sucessfully!"));
//			}
//		} catch (Exception e) {
//			e.getMessage();
//		}
//	}

}
