package com.br.backendhortifruti.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.backendhortifruti.model.entity.Produto;

import lombok.Getter;

@Getter
public class ProdutoDTO {
	
	private Integer codigo;
	
	private String nome;
	
	private String imagem;
	
	private String descricao;

    private String unidadeMedida;

    private double valorUnitario;
    
    private boolean status;

    public ProdutoDTO(Produto produto) {
    	this.codigo = produto.getCodigo();
    	this.nome = produto.getNome();
    	this.imagem = produto.getImagem();
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

}
