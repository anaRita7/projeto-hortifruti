package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Endereco;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoDTO {

    private String cep;
    private String cidade;
    private String bairro;
    private String estado;
    private String rua;
    private String complemento;
    private Integer numero;

    public EnderecoDTO(Endereco endereco){
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.bairro = endereco.getBairro();
        this.estado = endereco.getEstado();
        this.rua = endereco.getRua();
        this.complemento = endereco.getComplemento();
        this.numero = endereco.getNumero();
    }

    public static List<EnderecoDTO> converterLista(List<Endereco> enderecos){
        return enderecos.stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }

    public static EnderecoDTO converter(Endereco endereco){
        return new EnderecoDTO(endereco);
    }

}
