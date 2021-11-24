package com.br.backendhortifruti.model.service;

import java.util.List;

import com.br.backendhortifruti.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {

	Cliente incluirCliente(Cliente cliente);

	Page<Cliente> consultarClientes(Pageable pageable);

	List<Cliente> consultarClientes();

	Cliente consultarCliente(Integer id);
	
	Cliente consultarClientePorDocumento(String documento);

	Cliente alterarCliente(Cliente cliente, Integer id);

	void excluirCliente(Integer id);

}
