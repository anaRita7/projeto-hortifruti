package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Cliente;
import lombok.Getter;

@Getter
public class ClienteIdDTO {

    private Integer id;

    public ClienteIdDTO(Cliente cliente){
        this.id = cliente.getId();
    }

    public static ClienteIdDTO converter(Cliente cliente) {
        return new ClienteIdDTO(cliente);
    }

}
