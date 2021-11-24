package com.br.backendhortifruti.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.backendhortifruti.model.entity.Produto;

import lombok.Getter;

@Getter
public class ProdutoAtivoDTO {
	
	private Integer codigo;
	
	private String nome;
	
	private String descricao;

    private String unidadeMedida;

    private double valorUnitario;

    private String imagem;

    public ProdutoAtivoDTO(Produto produto) {
    	this.codigo = produto.getCodigo();
    	this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.valorUnitario = produto.getValorUnitario();
        this.imagem = produto.getImagem();
    }

    public static List<ProdutoAtivoDTO> converterList(List<Produto> produtos) {
        return produtos.stream().map(ProdutoAtivoDTO::new).collect(Collectors.toList());
    }

    public static ProdutoAtivoDTO converter(Produto produto) {
		return new ProdutoAtivoDTO(produto);
	}
	
}
