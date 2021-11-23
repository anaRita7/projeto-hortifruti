import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PedidoForConsult } from 'src/app/model/PedidoForConsult';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  pedidos: PedidoForConsult[] = []

  constructor(private service: PedidoService, private router:Router) {
    this.service.getPedidos().subscribe(data => this.pedidos = data);
  }

  ngOnInit(): void {
  }

}
