package com.br.backendhortifruti.model.service.impl;

import com.br.backendhortifruti.model.entity.Pedido;
import com.br.backendhortifruti.model.repository.PedidoRepository;
import com.br.backendhortifruti.model.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> consultarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido consultarPedido(Integer pedidoId) {
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);
        return pedido.orElse(null);
    }

    @Override
    public Pedido incluirPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido alterarPedido(int pedidoId, Pedido pedido) {
        if(pedidoRepository.findById(pedidoId).isPresent()){
            Pedido pedidoExistente = pedidoRepository.findById(pedidoId).get();
            pedidoExistente = pedido;
            return pedidoRepository.save(pedidoExistente);
        }
        return null;
    }

    @Override
    public void excluirPedido(int pedidoId) {
        pedidoRepository.deleteById(pedidoId);
    }

	@Override
	public Pedido consultarPedidoPorCodigo(Integer codigo) {
		Optional<Pedido> pedido = pedidoRepository.findByCodigo(codigo);
		if (pedido.isPresent())
			return pedido.get();
		return null;
	}

	

}
