package com.br.backendhortifruti.service.impl;

import com.br.backendhortifruti.model.Pedido;
import com.br.backendhortifruti.repository.PedidoRepository;
import com.br.backendhortifruti.service.PedidoService;

import java.util.List;

public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> consultarPedidos() {
        return pedidoRepository.findAll();
    }
}
