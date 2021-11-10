package com.br.backendhortifruti.repository;

import com.br.backendhortifruti.model.Pedido;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <Pedido, Integer> {
	
	Optional<Pedido> findByCodigo(Integer codigo);
	
}
