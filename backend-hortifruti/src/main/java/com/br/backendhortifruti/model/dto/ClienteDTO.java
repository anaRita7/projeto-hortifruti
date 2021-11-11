package com.br.backendhortifruti.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.backendhortifruti.model.entity.Cliente;

public class ClienteDTO {
	private String nome;
	private char tipo;
	private String documento;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
