package com.br.backendhortifruti.service;

import java.util.List;

import com.br.backendhortifruti.model.Item;

public interface ItemService {
	
	Item incluirItem(Item item);
	List<Item> consultarItens();
	Item consultarItem (int id);
	Item alterarItem(Item item, int id);
	void excluirItem(int id);
}
