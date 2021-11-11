package com.br.backendhortifruti.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.backendhortifruti.model.entity.Cliente;

import lombok.Getter;

@Getter
public class ClienteDTO {
	private String nome;
	private char tipo;
	private String documento;
	private String telefone;

	public ClienteDTO(Cliente cliente) {
		this.nome = cliente.getNome();
		this.tipo = cliente.getTipo();
		this.documento = cliente.getDocumento();
	}
	
	public static List<ClienteDTO> converterLista(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
	
	public static ClienteDTO converter(Cliente cliente) {
		return new ClienteDTO(cliente);
	}

}
