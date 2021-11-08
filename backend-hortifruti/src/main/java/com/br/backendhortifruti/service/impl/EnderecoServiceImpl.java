package com.br.backendhortifruti.service.impl;

import com.br.backendhortifruti.model.Endereco;
import com.br.backendhortifruti.repository.EnderecoRepository;
import com.br.backendhortifruti.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private EnderecoRepository enderecoRepository;


    @Override
    public List<Endereco> consultarEnderecos() {
        return enderecoRepository.findAll();
    }
}
