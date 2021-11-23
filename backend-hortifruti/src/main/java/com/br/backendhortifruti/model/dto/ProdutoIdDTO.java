package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Produto;
import lombok.Getter;

@Getter
public class ProdutoIdDTO {

    private Integer id;
    private double valorUnitario;

    public ProdutoIdDTO(Produto produto){
        this.id = produto.getId();
        this.valorUnitario = produto.getValorUnitario();
    }

    public static ProdutoIdDTO converter(Produto produto) {
        return new ProdutoIdDTO(produto);
    }

}
