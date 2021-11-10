package com.br.backendhortifruti.model.service;

import com.br.backendhortifruti.model.entity.Pedido;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PedidoService {
    List<Pedido> consultarPedidos();

    Pedido consultarPedido(Integer pedidoId);
    
    Pedido consultarPedidoPorCodigo(Integer codigo);

    Pedido incluirPedido(Pedido pedido);

    Pedido alterarPedido(int pedidoId, Pedido pedido);

    void excluirPedido(int pedidoId);
}
