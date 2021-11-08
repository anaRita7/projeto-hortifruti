package com.br.backendhortifruti.controller;

import java.util.List;

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

import com.br.backendhortifruti.model.Item;
import com.br.backendhortifruti.service.ItemService;

@RestController
@RequestMapping("/api/item")
public class ItemController {
	private ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Item>> consultarItens() {
        return new ResponseEntity<>(itemService.consultarItens(), HttpStatus.OK);
    }

	@PostMapping("")
	public ResponseEntity<Item> incluirItem(@RequestBody Item item){
		return new ResponseEntity<Item>(itemService.incluirItem(item), HttpStatus.CREATED);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> consultarItem(@PathVariable("id") int itemId) {
        return new ResponseEntity<Item>(itemService.consultarItem(itemId), HttpStatus.OK);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> alterarItem(@PathVariable("id") int itemId, @RequestBody Item item) {
        return new ResponseEntity<Item>(itemService.alterarItem(item, itemId), HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirItem(@PathVariable("id") int itemId) {
		itemService.excluirItem(itemId);
        return new ResponseEntity<String>("Item de pedido deleted sucessfully!",HttpStatus.OK);
    }
}
