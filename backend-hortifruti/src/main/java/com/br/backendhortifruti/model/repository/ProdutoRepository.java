package com.br.backendhortifruti.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.backendhortifruti.model.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Optional<Produto> findByCodigo(Integer codigo);

}