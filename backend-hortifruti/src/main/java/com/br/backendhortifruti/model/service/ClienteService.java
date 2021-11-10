package com.br.backendhortifruti.model.service;

import java.util.List;

import com.br.backendhortifruti.model.entity.Cliente;

public interface ClienteService {

	Cliente incluirCliente(Cliente cliente);

	List<Cliente> consultarClientes();

	Cliente consultarCliente(Integer id);
	
	Cliente consultarClientePorDocumento(String documento);

	Cliente alterarCliente(Cliente cliente, Integer id);

	void excluirCliente(Integer id);

}
