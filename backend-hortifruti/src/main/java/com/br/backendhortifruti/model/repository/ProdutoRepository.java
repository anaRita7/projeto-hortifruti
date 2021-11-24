package com.br.backendhortifruti.model.repository;

import java.util.List;
import java.util.Optional;

import com.br.backendhortifruti.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.backendhortifruti.model.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Optional<Produto> findByCodigo(Integer codigo);
	
	List<Produto> findByStatusTrue();
	
	Optional<Produto> findByStatusAndCodigo(boolean status, Integer codigo);

    List<Produto> findByStatusFalse();
}
