package com.br.backendhortifruti.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.br.backendhortifruti.controller.EnderecoController;
import com.br.backendhortifruti.model.dto.EnderecoDTO;
import com.br.backendhortifruti.model.dto.EnderecoIdDTO;
import com.br.backendhortifruti.model.entity.Endereco;

@SpringBootTest
public class EnderecoControllerTest {
	
	@Autowired
	EnderecoController enderecoController;
	
	@Test
	public void incluirEnderecoTest() {
		Endereco ed1 = new Endereco();
		ed1.setCep("72302703");
		ed1.setCidade("Brasilia");
		ed1.setBairro("Asa sul");
		ed1.setEstado("Distrito Federal");
		ed1.setRua("302 sul");
		ed1.setComplemento("Prox ao mercado");
		ed1.setNumero(16);
		
		ResponseEntity<EnderecoIdDTO> enderecoResponse = enderecoController.incluirEndereco(ed1);
		assertThat(enderecoResponse.getStatusCodeValue()).isEqualTo(201);
	}
	
	/*	@Test
	public void alterarEnderecoTest() {
		Endereco ed2 = new Endereco();
		ed2.setCep("72303392");
		ed2.setCidade("Brasilia");
		ed2.setBairro("Asa Norte");
		ed2.setEstado("Distrito Federal");
		ed2.setRua("410 norte");
		ed2.setComplemento("Prox a padaria");
		ed2.setNumero(112);
		
		ResponseEntity<String> enderecoResponse = enderecoController.alterarEndereco(6, ed2);
		assertThat(enderecoResponse.getStatusCodeValue()).isEqualTo(200);
	}  */
	
	@Test
	public void excluirEnderecoTest() {
		ResponseEntity<String> enderecoResponse = enderecoController.excluirEndereco(6);
		assertThat(enderecoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarEnderecosTest() {
		ResponseEntity<List<EnderecoDTO>> enderecoResponse = enderecoController.consultarEnderecos();
		assertThat(enderecoResponse.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void consultarEnderecoTest() {
		 ResponseEntity<EnderecoDTO> enderecoResponse = enderecoController.consultarEndereco(4);
		 assertThat(enderecoResponse.getStatusCodeValue()).isEqualTo(200);
	}
}
	
	
	