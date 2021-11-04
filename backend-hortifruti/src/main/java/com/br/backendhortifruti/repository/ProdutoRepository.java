package com.br.backendhortifruti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.backendhortifruti.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
