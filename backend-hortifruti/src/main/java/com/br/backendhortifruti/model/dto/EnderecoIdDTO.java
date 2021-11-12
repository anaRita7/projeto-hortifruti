package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Endereco;
import lombok.Getter;

@Getter
public class EnderecoIdDTO {

    private Integer id;

    public EnderecoIdDTO(Endereco endereco){
        this.id = endereco.getId();
    }

    public static EnderecoDTO converter(Endereco endereco){
        return new EnderecoDTO(endereco);
    }

}
