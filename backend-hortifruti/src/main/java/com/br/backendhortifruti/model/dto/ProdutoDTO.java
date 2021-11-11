package com.br.backendhortifruti.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.backendhortifruti.model.entity.Produto;

public class ProdutoDTO {
	private String descricao;

    private String unidadeMedida;

    private double valorUnitario;
    
    private boolean status;

    public ProdutoDTO(Produto produto) {
        this.descricao = produto.getDescricao();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valorUnitario = produto.getValorUnitario();
        this.status = produto.isStatus();
    }

    public static List<ProdutoDTO> converterList(List<Produto> produtos) {
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public static ProdutoDTO converter(Produto produto) {
		return new ProdutoDTO(produto);
	}
	public String getDescricao() {
		return descricao;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public boolean isStatus() {
		return status;
	}
    
}
