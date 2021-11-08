package com.br.backendhortifruti.service;

import com.br.backendhortifruti.model.Endereco;

import java.util.List;

public interface EnderecoService {

    List<Endereco> consultarEnderecos();

    Endereco incluirEndereco(Endereco endereco);

    Endereco consultarEndereco(int enderecoId);

    Endereco alterarEndereco(int enderecoId, Endereco endereco);
}
