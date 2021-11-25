package com.br.backendhortifruti.mockitoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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

import com.br.backendhortifruti.model.entity.Endereco;
import com.br.backendhortifruti.model.repository.EnderecoRepository;
import com.br.backendhortifruti.model.service.impl.EnderecoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoMockTest {
	
	@Mock
	private EnderecoRepository enderecoRepository;
	
	@InjectMocks
	private EnderecoServiceImpl enderecoServiceImpl;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@DisplayName("Cadastrar um novo endereco")
	@Test
	public void incluirEnderecoMockTest() {
		Endereco ed1 = new Endereco();
		
		when(enderecoRepository.save(Mockito.any(Endereco.class))).thenReturn(ed1);
		
		ed1.setCep("72302703");
		ed1.setLocalidade("Brasilia");
		ed1.setBairro("Asa Sul");
		ed1.setUf("Distrito Federal");
		ed1.setLogradouro("302 sul");
		ed1.setComplemento("Prox ao mercado");
		ed1.setNumero(16);
		
		Endereco enderecoResponse = enderecoServiceImpl.incluirEndereco(ed1);
		assertEquals(enderecoResponse.getCep(), "72302703");
		assertEquals(enderecoResponse.getLocalidade(), "Brasilia");
		assertEquals(enderecoResponse.getBairro(), "Asa Sul");
		assertEquals(enderecoResponse.getUf(), "Distrito Federal");
		assertEquals(enderecoResponse.getLogradouro(), "302 sul");
		assertEquals(enderecoResponse.getComplemento(), "Prox ao mercado");
		assertThat(enderecoResponse.getNumero() == 16);
	}
	
	@DisplayName("Alterar um endereco")
	@Test
	public void alterarEnderecoMockTest() {
		Endereco ed1 = new Endereco();
		
		when(enderecoRepository.findById(1)).thenReturn(Optional.of(ed1));
		when(enderecoRepository.save(Mockito.any(Endereco.class))).thenReturn(ed1);
		
		ed1.setCep("72302703");
		ed1.setLocalidade("Brasilia");
		ed1.setBairro("Asa Norte");
		ed1.setUf("Distrito Federal");
		ed1.setLogradouro("410 norte");
		ed1.setComplemento("Prox a padaria");
		ed1.setNumero(16);
		
		Endereco enderecoResponse = enderecoServiceImpl.alterarEndereco(1, ed1);
		assertEquals(enderecoResponse.getCep(), "72302703");
		assertEquals(enderecoResponse.getLocalidade(), "Brasilia");
		assertEquals(enderecoResponse.getBairro(), "Asa Norte");
		assertEquals(enderecoResponse.getUf(), "Distrito Federal");
		assertEquals(enderecoResponse.getLogradouro(), "410 norte");
		assertEquals(enderecoResponse.getComplemento(), "Prox a padaria");
		assertThat(enderecoResponse.getNumero() == 16);
	}
	
	@DisplayName("Consultar enderecos")
	@Test
	public void consultarEnderecoMockTest() {
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		
		when(enderecoRepository.findAll()).thenReturn(listaEnderecos);
		
		Endereco ed1 = new Endereco();
		ed1.setCep("72302703");
		ed1.setLocalidade("Brasilia");
		ed1.setBairro("Asa Sul");
		ed1.setUf("Distrito Federal");
		ed1.setLogradouro("302 sul");
		ed1.setComplemento("Prox ao mercado");
		ed1.setNumero(16);
		listaEnderecos.add(ed1);
		
		Endereco ed2 = new Endereco();
		ed2.setCep("72302703");
		ed2.setLocalidade("Brasilia");
		ed2.setBairro("Asa Norte");
		ed2.setUf("Distrito Federal");
		ed2.setLogradouro("410 norte");
		ed2.setComplemento("Prox a padaria");
		ed2.setNumero(16);
		listaEnderecos.add(ed2);
		
		List<Endereco> enderecoResponse = enderecoServiceImpl.consultarEnderecos();
		assertNotNull(enderecoResponse);
		assertThat(listaEnderecos.size() == 2);
	}
	
	@DisplayName("Consultar endereco por id")
	@Test
	public void consultarEnderecoPorIdMockTest() {
		Endereco ed1= new Endereco();
		ed1.setId(1);
		
		when(enderecoRepository.findById(1)).thenReturn(Optional.of(ed1));
		Endereco enderecoResponse = enderecoServiceImpl.consultarEndereco(1);
		assertNotNull(enderecoResponse);
		assertThat(ed1.getId() == 1);
	}
}