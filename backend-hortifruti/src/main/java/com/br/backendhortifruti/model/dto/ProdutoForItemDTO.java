package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Produto;
import lombok.Getter;

@Getter
public class ProdutoForItemDTO {

    private Integer id;
    
    private String nome;
    
    private String unidadeMedida;
    
    private double valorUnitario;
    
    private String imagem;

    public ProdutoForItemDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valorUnitario = produto.getValorUnitario();
        this.imagem = produto.getImagem(); 
    }

    public static ProdutoForItemDTO converter(Produto produto) {
        return new ProdutoForItemDTO(produto);
    }

}
