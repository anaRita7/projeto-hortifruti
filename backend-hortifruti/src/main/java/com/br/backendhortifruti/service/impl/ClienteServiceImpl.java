package com.br.backendhortifruti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.backendhortifruti.model.Cliente;
import com.br.backendhortifruti.repository.ClienteRepository;
import com.br.backendhortifruti.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente incluirCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> consultarClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente consultarCliente(Integer id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public Cliente alterarCliente(Cliente cliente, Integer id) {
		if (clienteRepository.findById(id).isPresent()) {
			Cliente clienteRetornado = clienteRepository.findById(id).get();
			clienteRetornado.setNome(cliente.getNome());
			clienteRetornado.setTipo(cliente.getTipo());
			clienteRetornado.setDocumento(cliente.getDocumento());
			clienteRepository.save(clienteRetornado);
			return clienteRetornado;
		}
		;
		return null;
	}

	@Override
	public void excluirCliente(Integer id) {
		clienteRepository.deleteById(id);
	}

}
