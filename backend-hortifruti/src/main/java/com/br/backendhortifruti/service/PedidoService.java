package com.br.backendhortifruti.service;

import com.br.backendhortifruti.model.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> consultarPedidos();

    Pedido consultarPedido(Integer pedidoId);

    Pedido incluirPedido(Pedido pedido);
}
