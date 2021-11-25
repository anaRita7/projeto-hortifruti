package com.br.backendhortifruti.model.service.impl;

import com.br.backendhortifruti.model.entity.Pedido;
import com.br.backendhortifruti.model.repository.PedidoRepository;
import com.br.backendhortifruti.model.service.PedidoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
				pedido.setDataHora(LocalDateTime.now().atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("America/Sao_Paulo")).toLocalDateTime());
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
		return pedido.orElse(null);
	}

	@Override
	public Page<Pedido> consultarPedidos(Pageable pageable) {
		return pedidoRepository.findAll(pageable);
	}


}
