package com.br.backendhortifruti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.backendhortifruti.model.Item;
import com.br.backendhortifruti.repository.ItemRepository;
import com.br.backendhortifruti.service.ItemService;

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
		Optional<Item> item = itemRepository.findById(id);
		if (item.isPresent())
			return item.get();
		return null;
	}

	@Override
	public Item alterarItem(Item item, int id) {
		Item existingItem = null;
		if(itemRepository.findById(id).isPresent())
			existingItem = itemRepository.findById(id).get();
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
