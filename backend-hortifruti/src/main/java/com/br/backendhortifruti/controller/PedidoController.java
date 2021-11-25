package com.br.backendhortifruti.controller;

import com.br.backendhortifruti.model.dto.PedidoForPageDTO;
import com.br.backendhortifruti.model.dto.PedidoIdDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

import com.br.backendhortifruti.model.dto.ClienteIdDTO;
import com.br.backendhortifruti.model.dto.PedidoDTO;
import com.br.backendhortifruti.model.dto.PedidoForListDTO;
import com.br.backendhortifruti.model.entity.Pedido;
import com.br.backendhortifruti.model.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping("/page")
	public ResponseEntity<PageImpl<PedidoForPageDTO>> consultarPedidos(Pageable pageable) {
		Page<Pedido> page = pedidoService.consultarPedidos(pageable);
		PageImpl<PedidoForPageDTO> pageDTO = new PageImpl<>(PedidoForPageDTO.converterList(page.getContent()),pageable, page.getTotalElements());
		return new ResponseEntity<>(pageDTO, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PedidoForListDTO>> consultarPedidos() {
		List<Pedido> pedidos = pedidoService.consultarPedidosAtivos();
		pedidos.addAll(pedidoService.consultarPedidosInativos());
		return new ResponseEntity<>(PedidoForListDTO.converterList(pedidos), HttpStatus.OK);
	}


	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<PedidoDTO> consultarPedidoPorCodigo(@PathVariable("codigo") Integer codigo) {
		try{
			Pedido pedido = pedidoService.consultarPedidoPorCodigo(codigo);
			return new ResponseEntity<>(PedidoDTO.converter(pedido), HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> consultarPedido(@PathVariable("id") Integer pedidoId) {
		try{
			Pedido pedido = pedidoService.consultarPedido(pedidoId);
			return new ResponseEntity<>(PedidoDTO.converter(pedido), HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
	}

	@PostMapping
	public ResponseEntity<PedidoIdDTO> incluirPedido(@RequestBody Pedido pedido) {
		Pedido pedidoResponse = pedidoService.incluirPedido(pedido);
		if (pedidoResponse == null) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<PedidoIdDTO>(PedidoIdDTO.converter(pedidoResponse), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> alterarPedido(@PathVariable("id") int pedidoId, @RequestBody Pedido pedido) {
		try{
			pedidoService.alterarPedido(pedidoId, pedido);
			return new ResponseEntity<>("Pedido Alterado com sucesso!", HttpStatus.OK);
		}catch (NullPointerException e){
			throw new NullPointerException();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirPedido(@PathVariable("id") int pedidoId) {
		pedidoService.excluirPedido(pedidoId);
		return new ResponseEntity<>("Pedido deletado com sucesso!", HttpStatus.OK);
	}

}
