package com.br.backendhortifruti.controller;

import com.br.backendhortifruti.model.Pedido;
import com.br.backendhortifruti.service.PedidoService;
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

    @PostMapping("")
    public ResponseEntity<Pedido> consultarPedido(@PathVariable ("id") Integer pedidoId){
        return new ResponseEntity<Pedido>(pedidoService.consultarPedido(pedidoId), HttpStatus.OK);
    }
}

