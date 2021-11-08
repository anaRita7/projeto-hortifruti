package com.br.backendhortifruti.service;

import java.util.List;

import com.br.backendhortifruti.model.Cliente;

public interface ClienteService {

	public Cliente incluirCliente(Cliente cliente);

	public List<Cliente> consultarClientes();

	public Cliente consultarCliente(Integer id);

	public Cliente alterarCliente(Cliente cliente, Integer id);

	public void excluirCliente(Integer id);

}
