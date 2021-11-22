package com.br.backendhortifruti.controllerTest;

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
import com.br.backendhortifruti.model.repository.ClienteRepository;
import com.br.backendhortifruti.model.service.impl.ClienteServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ClienteControllerMockTest {
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@DisplayName("Register a new client")
	@Test
	public void incluirClienteMockTest() {
		Cliente cliente = new Cliente();
		
		when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);
		
		cliente.setNome("Inajara Pereira");
		cliente.setTipo('F');
		cliente.setDocumento("063.785.409-85");
		cliente.setTelefone("99999999999");
		
		Cliente clienteResponse = clienteServiceImpl.incluirCliente(cliente);
		assertEquals(clienteResponse.getNome(), "Inajara Pereira");
		assertEquals(clienteResponse.getTipo(), 'F');
		assertEquals(clienteResponse.getDocumento(), "063.785.409-85");
		assertEquals(clienteResponse.getTelefone(), "99999999999");
		// assertThat(clienteResponse.getNome().equals("Inajara Pereira"));
	}
	
	@DisplayName("Replace client")
	@Test
	public void alterarClienteMockTest() {
		Cliente cliente = new Cliente();
		
		when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente)); //obs
		when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);
		
		cliente.setNome("Bruna Lima");
		cliente.setTipo('F');
		cliente.setDocumento("072.097.771-13");
		cliente.setTelefone("99999999999");
		
		Cliente clienteResponse = clienteServiceImpl.alterarCliente(cliente, 1);
		assertEquals(clienteResponse.getNome(), "Bruna Lima");
		assertEquals(clienteResponse.getTipo(), 'F');
		assertEquals(clienteResponse.getDocumento(), "072.097.771-13");
		assertEquals(clienteResponse.getTelefone(), "99999999999");
	} 
}