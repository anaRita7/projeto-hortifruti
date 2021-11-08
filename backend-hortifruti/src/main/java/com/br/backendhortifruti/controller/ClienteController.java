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

import com.br.backendhortifruti.model.Cliente;
import com.br.backendhortifruti.service.ClienteService;
import com.br.backendhortifruti.service.impl.ClienteServiceImpl;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	@PostMapping("")
	public ResponseEntity<Cliente>  incluirCliente(@RequestBody Cliente cliente) {
		Cliente clienteResponse = clienteServiceImpl.incluirCliente(cliente);
		return ResponseEntity.ok().body(clienteResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alterarCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
		Cliente clienteResponse = clienteServiceImpl.alterarCliente(cliente, id);
		return ResponseEntity.ok().body(clienteResponse);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> consultarCliente(@PathVariable Integer id) {
		Cliente clienteResponse = clienteServiceImpl.consultarCliente(id);
		return ResponseEntity.ok().body(clienteResponse);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Cliente>> consultarClientes() {
		List<Cliente> list = clienteServiceImpl.consultarClientes();
		return ResponseEntity.ok().body(list);
	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirCliente(@PathVariable Integer id) {
		clienteServiceImpl.excluirCliente(id);;
        return new ResponseEntity<String>("Produto deleted sucessfully!",HttpStatus.OK);
    }

}
