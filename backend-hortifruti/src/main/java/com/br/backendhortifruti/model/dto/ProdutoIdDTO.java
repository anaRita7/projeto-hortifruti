package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Produto;
import lombok.Getter;

@Getter
public class ProdutoIdDTO {

    private Integer id;

    public ProdutoIdDTO(Produto produto){
        this.id = produto.getId();
    }

    public static ProdutoIdDTO converter(Produto produto) {
        return new ProdutoIdDTO(produto);
    }

}
