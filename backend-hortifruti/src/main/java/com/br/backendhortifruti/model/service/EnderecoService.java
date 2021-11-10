package com.br.backendhortifruti.model.service;

import com.br.backendhortifruti.model.entity.Endereco;

import java.util.List;

public interface EnderecoService {

    List<Endereco> consultarEnderecos();

    Endereco incluirEndereco(Endereco endereco);

    Endereco consultarEndereco(Integer enderecoId);

    Endereco alterarEndereco(Integer enderecoId, Endereco endereco);

    void excluirEndereco(Integer enderecoId);
}
