package com.br.backendhortifruti.controller;

import com.br.backendhortifruti.model.entity.Pedido;
import com.br.backendhortifruti.model.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @GetMapping("")
    public ResponseEntity <List<Pedido>> consultarPedidos(){
        return new ResponseEntity<>(pedidoService.consultarPedidos(), HttpStatus.OK);
    }

    @GetMapping("/codigo/{codigo}")
	public ResponseEntity<Pedido> consultarPedidoPorCodigo(@PathVariable("codigo") Integer codigo) {
		return new ResponseEntity<Pedido>(pedidoService.consultarPedidoPorCodigo(codigo), HttpStatus.OK);
	}
    
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> consultarPedido(@PathVariable ("id") Integer pedidoId){
        return new ResponseEntity<Pedido>(pedidoService.consultarPedido(pedidoId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Pedido> incluirPedido(@RequestBody Pedido pedido){
        return new ResponseEntity<Pedido>(pedidoService.incluirPedido(pedido), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> alterarPedido(@PathVariable("id") int pedidoId, @RequestBody Pedido pedido){
        return new ResponseEntity<Pedido>(pedidoService.alterarPedido(pedidoId, pedido), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirPedido(@PathVariable("id") int pedidoId){
        pedidoService.excluirPedido(pedidoId);
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }


}

