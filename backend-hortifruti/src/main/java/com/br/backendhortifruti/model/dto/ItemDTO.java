package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Item;
import com.br.backendhortifruti.model.entity.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDTO {

    private Produto produto;
    private Integer quantidadeTotal;
    private float valorTotal;

    public ItemDTO(Item item){
        this.produto = item.getProduto();
        this.quantidadeTotal = item.getQuantidadeTotal();
        this.valorTotal = item.getValorTotal();
    }

    public static List<ItemDTO> converterLista(List<Item> itens){
        return itens.stream().map(ItemDTO::new).collect(Collectors.toList());
    }

    public static ItemDTO converter(Item item){
        return new ItemDTO(item);
    }
}
