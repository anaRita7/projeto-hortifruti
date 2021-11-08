package com.br.backendhortifruti.service.impl;

import com.br.backendhortifruti.model.Endereco;
import com.br.backendhortifruti.repository.EnderecoRepository;
import com.br.backendhortifruti.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private EnderecoRepository enderecoRepository;

    @Override
    public List<Endereco> consultarEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco incluirEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco consultarEndereco(int enderecoId) {
        Optional<Endereco> endereco = enderecoRepository.findById(enderecoId);
        return endereco.orElse(null);
    }
}
