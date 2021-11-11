package com.br.backendhortifruti.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.backendhortifruti.model.entity.Item;
import com.br.backendhortifruti.model.repository.ItemRepository;
import com.br.backendhortifruti.model.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	private ItemRepository itemRepository;

	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Override
	public Item incluirItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> consultarItens() {
		return itemRepository.findAll();
	}

	@Override
	public Item consultarItem(int id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public Item alterarItem(Item item, int id) {
		Item existingItem = itemRepository.findById(id).get();
		existingItem.setQuantidadeTotal(item.getQuantidadeTotal());
		existingItem.setValorTotal(item.getValorTotal());
		
		itemRepository.save(existingItem);
		return existingItem;
	}

	@Override
	public void excluirItem(int id) {
		itemRepository.deleteById(id);
	}
	
}
