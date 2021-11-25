import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pedido } from 'src/app/model/Pedido';
import { PedidoForConsult } from 'src/app/model/PedidoForConsult';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  pedidos: PedidoForConsult[] = []
  pedido: Pedido = new Pedido();

  constructor(private service: PedidoService) {
    this.service.getPedidos().subscribe(data => this.pedidos = data)
  }

  ngOnInit(): void {
  }

  detalharPedido(codigo: any){
    this.service.getPedidoCodigo(codigo).subscribe(data => this.pedido = data)
  }

}
