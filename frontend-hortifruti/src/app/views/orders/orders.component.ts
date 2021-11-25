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
  pedido: PedidoForConsult = new PedidoForConsult();

  page = 1;
  count = 0;
  pageSize = 5;
  pageSizes = [5, 10, 15];
  sort = "situacao,asc";

  constructor(private service: PedidoService, private router:Router) {
    this.retrievePedido();
  }

  ngOnInit(): void {
  }

  getRequestParams(page: number, pageSize: number, sort: string): any {
    let params: any = {};
    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }
    
    params[`sort`] = sort;

    return params;
  }

  retrievePedido(): void {
    const params = this.getRequestParams(this.page, this.pageSize, this.sort);
    this.service.getPedidos(params)
    .subscribe(
      response => {
        this.pedidos = response.content;
        this.count = response.totalElements;
      },
      error => {
        console.log(error);
      });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrievePedido();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrievePedido();
  }


}
