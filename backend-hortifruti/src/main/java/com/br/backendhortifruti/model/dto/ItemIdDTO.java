package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Item;

import lombok.Getter;

@Getter
public class ItemIdDTO {

	private Integer id;

    public ItemIdDTO(Item item){
        this.id = item.getId();
    }

    public static ItemIdDTO converter(Item item) {
        return new ItemIdDTO(item);
    }
}
