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

  pedidos: PedidoForConsult[] = [];
  pedido: Pedido = new Pedido();
  mostrar: boolean = false;
  percDesconto: any;

  page = 1;
  count = 0;
  pageSize = 5;
  pageSizes = [5, 10, 15];
  sort = "situacao,desc";

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

  detalharPedido(codigo: any){
    this.mostrar = true;
    this.service.getPedidoCodigo(codigo).subscribe(data => this.pedido = data)
  }

  irModalEditar(codigo: any){
    this.service.getPedidoCodigo(codigo).subscribe(data => {
      this.pedido = data
      this.percDesconto = this.pedido.desconto*100
      console.log(this.pedido)
    })
  }

  aplicarDesconto(){
    this.pedido.valorFinal = this.pedido.valorTotal - ((this.percDesconto/100)*this.pedido.valorTotal)
    this.pedido.desconto = this.percDesconto/100
  }

  editarPedido(){
    const pedido = {
      id: this.pedido.id,
      cliente:{
        id: this.pedido.cliente.id
      },
      endereco: {
        id: this.pedido.endereco.id
      },
      situacao: this.pedido.situacao,
      quantidadeTotal: this.pedido.quantidadeTotal,
      valorTotal: this.pedido.valorTotal,
      desconto:this.pedido.desconto,
      formaPagamento: this.pedido.formaPagamento,
      valorFinal: this.pedido.valorFinal
    }

    this.service.editPedido(this.pedido.id,pedido).subscribe(
      data => 
      {
        alert('Pedido editado com sucesso!');
        this.reloadCurrentRoute();
      },
      erro =>
      {
        switch(erro.status) {
          case 400:
            alert(erro.error.mensagem);
            break;
          case 404:
            alert('Pedido não localizado!');
            break;
        }
      })
  }

  reloadCurrentRoute() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
  }

}
