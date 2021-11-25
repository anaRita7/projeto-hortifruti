package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Pedido;

import lombok.Getter;

@Getter
public class PedidoIdDTO {
	
	private Integer id;
	
	public PedidoIdDTO(Pedido pedido){
        this.id = pedido.getId();
    }

    public static PedidoIdDTO converter(Pedido pedido) {
        return new PedidoIdDTO(pedido);
    }

}
