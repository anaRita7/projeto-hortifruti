package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Item;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ItemDTO {

    private ProdutoDTO produto;
    private Integer quantidadeTotal;
    private float valorTotal;

    public ItemDTO(Item item){
        this.produto = item.getProdutoDTO();
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
