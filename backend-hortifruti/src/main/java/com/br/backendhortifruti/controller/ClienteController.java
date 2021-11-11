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
import com.br.backendhortifruti.model.entity.Cliente;
import com.br.backendhortifruti.model.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("")
	public ResponseEntity<Cliente> incluirCliente(@RequestBody Cliente cliente) {
		if(clienteService.incluirCliente(cliente) == null) {
			return new ResponseEntity<Cliente>(clienteService.incluirCliente(cliente), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<Cliente>(clienteService.incluirCliente(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alterarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
		Cliente clienteResponse = clienteService.alterarCliente(cliente, id);
		return ResponseEntity.ok().body(clienteResponse);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> consultarCliente(@PathVariable Integer id) {
		Cliente clienteResponse = clienteService.consultarCliente(id);
		return new ResponseEntity<ClienteDTO>(ClienteDTO.converter(clienteResponse), HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<ClienteDTO>> consultarClientes() {
		List<Cliente> list = clienteService.consultarClientes();
		return new ResponseEntity<>(ClienteDTO.converterLista(list), HttpStatus.OK);
	}

	@GetMapping("/documento/{documento}")
	public ResponseEntity<ClienteDTO> consultarClientePorDocumento(@PathVariable("documento") String documento) {
		Cliente cliente = clienteService.consultarClientePorDocumento(documento);
		return new ResponseEntity<ClienteDTO>(ClienteDTO.converter(cliente), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirCliente(@PathVariable Integer id) {
		clienteService.excluirCliente(id);
		return new ResponseEntity<String>("Produto deleted sucessfully!", HttpStatus.OK);
	}

}
