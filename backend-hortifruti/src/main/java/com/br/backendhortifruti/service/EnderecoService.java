package com.br.backendhortifruti.service;

import com.br.backendhortifruti.model.Endereco;

import java.util.List;

public interface EnderecoService {

    List<Endereco> consultarEnderecos();

    Endereco incluirEndereco(Endereco endereco);

    Endereco consultarEndereco(Integer enderecoId);

    Endereco alterarEndereco(Integer enderecoId, Endereco endereco);

    void excluirEndereco(Integer enderecoId);
}
