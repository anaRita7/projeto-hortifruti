package com.br.backendhortifruti.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.backendhortifruti.model.entity.Cliente;
import com.br.backendhortifruti.model.repository.ClienteRepository;
import com.br.backendhortifruti.model.service.ClienteService;
import com.br.backendhortifruti.model.service.util.ValidadorDocumento;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente incluirCliente(Cliente cliente) {
		String documentoValido = ValidadorDocumento.verificaDocumento(cliente.getDocumento());
		if (documentoValido != null) {
			cliente.setDocumento(documentoValido);
			return clienteRepository.save(cliente);
		}
		return null;
	}

	@Override
	public Page<Cliente> consultarClientes(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	@Override
	public List<Cliente> consultarClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente consultarCliente(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElse(null);
	}

	@Override
	public Cliente alterarCliente(Cliente cliente, Integer id) {
		if (clienteRepository.findById(id).isPresent()) {
			Cliente clienteRetornado = clienteRepository.findById(id).get();
			clienteRetornado.setNome(cliente.getNome());
			clienteRetornado.setTipo(cliente.getTipo());
			clienteRetornado.setDocumento(cliente.getDocumento());
			clienteRetornado.setTelefone(cliente.getTelefone());
			clienteRepository.save(clienteRetornado);
			return clienteRetornado;
		}
		return null;
	}

	@Override
	public void excluirCliente(Integer id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public Cliente consultarClientePorDocumento(String documento) {
		Optional<Cliente> cliente = clienteRepository.findByDocumento(documento);
		return cliente.orElse(null);
	}

}
