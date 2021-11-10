package com.br.backendhortifruti.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.backendhortifruti.model.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
