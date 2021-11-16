package com.br.backendhortifruti.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		//Formatação de caracteries será feita futuramento no front!
		String documento = ValidadorDocumento.removeCaracteresEspeciais(cliente.getDocumento());
		cliente.setDocumento(documento);
		
		//Chamada do método validador
		boolean documentoValido = ValidadorDocumento.validaDocumento(cliente);
		if(documentoValido) {
			//Salva o cliente com CPF/CNPJ ok
			return clienteRepository.save(cliente);
		}
		return null;
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
		if (cliente.isPresent())
			return cliente.get();
		return null;
	}

}
