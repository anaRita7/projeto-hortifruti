package com.br.backendhortifruti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.backendhortifruti.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
