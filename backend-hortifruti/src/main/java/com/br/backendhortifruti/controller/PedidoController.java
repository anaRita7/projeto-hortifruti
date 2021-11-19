package com.br.backendhortifruti.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.backendhortifruti.model.dto.PedidoDTO;
import com.br.backendhortifruti.model.dto.PedidoForListDTO;
import com.br.backendhortifruti.model.entity.Pedido;
import com.br.backendhortifruti.model.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping("")
	public ResponseEntity<List<PedidoForListDTO>> consultarPedidos() {
		List<Pedido> pedidos = pedidoService.consultarPedidosAtivos();
		pedidos.addAll(pedidoService.consultarPedidosInativos());
		return new ResponseEntity<>(PedidoForListDTO.converterList(pedidos), HttpStatus.OK);
	}

	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<PedidoDTO> consultarPedidoPorCodigo(@PathVariable("codigo") Integer codigo) {
		Pedido pedido = pedidoService.consultarPedidoPorCodigo(codigo);
		return new ResponseEntity<PedidoDTO>(PedidoDTO.converter(pedido), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> consultarPedido(@PathVariable("id") Integer pedidoId) {
		Pedido pedido = pedidoService.consultarPedido(pedidoId);
		return new ResponseEntity<PedidoDTO>(PedidoDTO.converter(pedido), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<String> incluirPedido(@RequestBody Pedido pedido) {
		Pedido pedidoResponse = pedidoService.incluirPedido(pedido);
		if (pedidoResponse == null) {
			return new ResponseEntity<String>("Falha ao salvar o pedido!", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<String>("Pedido salvo com sucesso!", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> alterarPedido(@PathVariable("id") int pedidoId, @RequestBody Pedido pedido) {
		pedidoService.alterarPedido(pedidoId, pedido);
		return new ResponseEntity<String>("Pedido Alterado com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirPedido(@PathVariable("id") int pedidoId) {
		pedidoService.excluirPedido(pedidoId);
		return new ResponseEntity<String>("Pedido deletado com sucesso!", HttpStatus.OK);
	}

}
