package com.br.backendhortifruti.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.backendhortifruti.model.entity.Produto;

import lombok.Getter;

@Getter
public class ProdutoDTO {
	private String descricao;

    private String unidadeMedida;

    private double valorUnitario;

    public ProdutoDTO(Produto produto) {
        this.descricao = produto.getDescricao();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valorUnitario = produto.getValorUnitario();
    }

    public static List<ProdutoDTO> converterList(List<Produto> produtos) {
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public static ProdutoDTO converter(Produto produto) {
		return new ProdutoDTO(produto);
	}
	
}
