import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';
import { Pedido } from 'src/app/model/Pedido';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-tax-invoice',
  templateUrl: './tax-invoice.component.html',
  styleUrls: ['./tax-invoice.component.css']
})
export class TaxInvoiceComponent implements OnInit {

  pedido: Pedido = new Pedido();
  id:any;

  constructor(private pedidoService:PedidoService, private router: ActivatedRoute) {
    this.id = this.router.snapshot.paramMap.get("id");
    this.pedidoService.getPedido(this.id).subscribe(
      data => this.pedido = data
    )
   }

  ngOnInit(): void {
  }

}
