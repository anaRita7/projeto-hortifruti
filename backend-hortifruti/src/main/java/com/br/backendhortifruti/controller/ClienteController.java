package com.br.backendhortifruti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.backendhortifruti.model.dto.ClienteDTO;
import com.br.backendhortifruti.model.dto.ClienteIdDTO;
import com.br.backendhortifruti.model.entity.Cliente;
import com.br.backendhortifruti.model.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteIdDTO> incluirCliente(@RequestBody Cliente cliente) {
		Cliente clienteResponse = clienteService.incluirCliente(cliente);
		if(clienteResponse == null) {
			return new ResponseEntity<ClienteIdDTO>(ClienteIdDTO.converter(clienteResponse), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ClienteIdDTO>(ClienteIdDTO.converter(clienteResponse), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> alterarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
		try {
			Cliente clienteResponse = clienteService.alterarCliente(cliente, id);
			return new ResponseEntity<ClienteDTO>(ClienteDTO.converter(clienteResponse), HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> consultarCliente(@PathVariable Integer id) {
		try{
			Cliente clienteResponse = clienteService.consultarCliente(id);
			return new ResponseEntity<ClienteDTO>(ClienteDTO.converter(clienteResponse), HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> consultarClientes() {
		List<Cliente> list = clienteService.consultarClientes();
		return new ResponseEntity<>(ClienteDTO.converterLista(list), HttpStatus.OK);
	}

	@GetMapping("/documento/{documento}")
	public ResponseEntity<ClienteIdDTO> consultarClientePorDocumento(@PathVariable("documento") String documento) {
		try{
            Cliente cliente = clienteService.consultarClientePorDocumento(documento);
            return new ResponseEntity<ClienteIdDTO>(ClienteIdDTO.converter(cliente), HttpStatus.OK);}
		catch (NullPointerException e){
			throw new NullPointerException();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirCliente(@PathVariable Integer id) {
		clienteService.excluirCliente(id);
		return new ResponseEntity<String>("Cliente excluído com sucesso!", HttpStatus.OK);
	}

}
