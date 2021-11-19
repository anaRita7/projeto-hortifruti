package com.br.backendhortifruti.model.service.impl;

import com.br.backendhortifruti.model.entity.Pedido;
import com.br.backendhortifruti.model.repository.PedidoRepository;
import com.br.backendhortifruti.model.service.PedidoService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PedidoServiceImpl implements PedidoService {

	private PedidoRepository pedidoRepository;

	Random random = new Random();

	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
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
		if(pedido.getCodigo() == null) {
			Integer codigoGerado = (random.nextInt(10000) + 1000);
			if (consultarPedidoPorCodigo(codigoGerado) == null) {
				pedido.setCodigo(codigoGerado);
				return pedidoRepository.save(pedido);
			}
		}
		return null;
	}

	@Override
	public Pedido alterarPedido(int pedidoId, Pedido pedido) {
		if (pedidoRepository.findById(pedidoId).isPresent()) {
			Pedido pedidoExistente = pedidoRepository.findById(pedidoId).get();
			pedidoExistente.setDataHora(pedido.getDataHora());
			pedidoExistente.setCliente(pedido.getCliente());
			pedidoExistente.setEndereco(pedido.getEndereco());
			pedidoExistente.setSituacao(pedido.isSituacao());
			pedidoExistente.setValorTotal(pedido.getValorTotal());
			pedidoExistente.setQuantidadeTotal(pedido.getQuantidadeTotal());
			pedidoExistente.setDesconto(pedido.getDesconto());
			pedidoExistente.setValorFinal(pedido.getValorFinal());
			pedidoExistente.setFormaPagamento(pedido.getFormaPagamento());
			
			pedidoRepository.save(pedidoExistente);
			return pedidoExistente;
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

	@Override
	public List<Pedido> consultarPedidosAtivos() {
		return pedidoRepository.findBySituacaoTrue();
	}

	@Override
	public List<Pedido> consultarPedidosInativos() {
		return pedidoRepository.findBySituacaoFalse();
	}

}
