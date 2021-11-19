package com.br.backendhortifruti.controller;

import java.util.List;

import com.br.backendhortifruti.model.dto.ItemDTO;
import com.br.backendhortifruti.model.dto.ItemIdDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.backendhortifruti.model.entity.Item;
import com.br.backendhortifruti.model.service.ItemService;

@RestController
@RequestMapping("/api/item")
public class ItemController {
	
	private ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<ItemDTO>> consultarItens() {
		List<Item> list = itemService.consultarItens();
        return new ResponseEntity<>(ItemDTO.converterLista(list), HttpStatus.OK);
    }

	@PostMapping("")
	public ResponseEntity<ItemIdDTO> incluirItem(@RequestBody Item item){
		Item itemResponse = itemService.incluirItem(item);
		return new ResponseEntity<ItemIdDTO>(ItemIdDTO.converter(itemResponse),HttpStatus.CREATED);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemDTO> consultarItem(@PathVariable Integer id) {
		try{
			Item itemResponse = itemService.consultarItem(id);
        	return new ResponseEntity<ItemDTO>(ItemDTO.converter(itemResponse), HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<String> alterarItem(@PathVariable("id") Integer id, @RequestBody Item item) {
		try {
			itemService.alterarItem(item, id);
			return new ResponseEntity<String>("Item de pedido alterado com sucesso!", HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirItem(@PathVariable Integer id) {
		itemService.excluirItem(id);
        return new ResponseEntity<String>("Item de pedido deletado com sucesso!",HttpStatus.OK);
    }

}