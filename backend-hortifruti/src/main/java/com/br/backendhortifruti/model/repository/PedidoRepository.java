package com.br.backendhortifruti.model.repository;

import com.br.backendhortifruti.model.entity.Pedido;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <Pedido, Integer> {
	
	Optional<Pedido> findByCodigo(Integer codigo);
	
	List<Pedido> findBySituacaoTrue();
	
	List<Pedido> findBySituacaoFalse();
	
}
