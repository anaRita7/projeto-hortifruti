package com.br.backendhortifruti.model.service.impl;

import com.br.backendhortifruti.model.entity.Endereco;
import com.br.backendhortifruti.model.repository.EnderecoRepository;
import com.br.backendhortifruti.model.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<Endereco> consultarEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco incluirEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco consultarEndereco(Integer enderecoId) {
        return enderecoRepository.findById(enderecoId).get();
    }

    @Override
    public Endereco alterarEndereco(Integer enderecoId, Endereco endereco) {
        if(enderecoRepository.findById(enderecoId).isPresent()){
            Endereco enderecoExistente = enderecoRepository.findById(enderecoId).get();
            enderecoExistente = endereco;
            return enderecoRepository.save(enderecoExistente);
        } return null;
    }

    @Override
    public void excluirEndereco(Integer enderecoId) {
        enderecoRepository.deleteById(enderecoId);
    }
}
