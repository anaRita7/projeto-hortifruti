package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Endereco;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class EnderecoDTO {

    private String cep;
    private String localidade;
    private String bairro;
    private String uf;
    private String logradouro;
    private String complemento;
    private Integer numero;

    public EnderecoDTO(Endereco endereco){
        this.cep = endereco.getCep();
        this.localidade = endereco.getLocalidade();
        this.bairro = endereco.getBairro();
        this.uf = endereco.getUf();
        this.logradouro = endereco.getLogradouro();
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
