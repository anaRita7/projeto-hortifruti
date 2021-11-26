import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/model/Cliente';
import { Endereco } from 'src/app/model/Endereco';
import { Item } from 'src/app/model/Item';
import { Pedido } from 'src/app/model/Pedido';
import { BuscaCEPService } from 'src/app/services/busca-cep.service';
import { ClienteService } from 'src/app/services/cliente.service';
import { EnderecoService } from 'src/app/services/endereco.service';
import { ItemService } from 'src/app/services/item.service';
import { PedidoService } from 'src/app/services/pedido.service';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  percDesconto: any
  idCliente: any
  idPedido: any
  soma: any
  endereco: Endereco = new Endereco();
  itens: Item[] = [];
  pedido: Pedido = new Pedido;
  cliente: Cliente = new Cliente;

  constructor(private pedidoService: PedidoService,private router: Router, private endService: EnderecoService, private itemService: ItemService, private serviceBuscaCep: BuscaCEPService, private serviceProd: ProdutoService, private cliService:ClienteService) {
    this.itens = JSON.parse(localStorage.getItem("itens")||"[]");
  }

  ngOnInit(): void {
    this.soma = 0;
    this.percDesconto = 0;
    this.updateTotal();
  }

  aplicarDesconto(){
    this.pedido.valorFinal = this.pedido.valorTotal - ((this.percDesconto/100)*this.pedido.valorTotal)
    this.pedido.desconto = this.percDesconto/100
  }

  updateTotal(){
    this.soma = 0
    this.itens.forEach(element => {
      this.soma += element.valorTotal
    });
    this.pedido.valorTotal = this.soma;
    this.aplicarDesconto()
  }

  geraEndereco(inputCep: any){
    this.serviceBuscaCep.buscarCEP(inputCep).subscribe(
      data => this.endereco = data
    )
  }

  removeItem(item: Item){
    const index = this.itens.indexOf(item);
    this.itens.splice(index, 1);
    localStorage.setItem("itens",JSON.stringify(this.itens))
    this.updateTotal()
  }

  buscarDocumento(){
    this.cliService.getClientePorDocumento(this.cliente.documento).subscribe(data =>
      {
        this.idCliente = data.id
        this.salvarPedido();
      },
      erro =>
      {
        if(erro.status == 404) {
            alert('Cliente não localizado!');
        }
      })
  }

  salvarCliente(){
    this.cliService.postCliente(this.cliente).subscribe(data => {
      this.idCliente = data.id
    }) 
    this.salvarPedido()
  }

  salvarPedido(){
    this.pedido.quantidadeTotal = this.itens.length;
    this.endService.postEndereco(this.endereco).subscribe(data => {
    const pedido = {
      cliente:{
        id: this.idCliente
      },
      endereco: {
        id: data.id
      },
      situacao: this.pedido.situacao,
      quantidadeTotal: this.pedido.quantidadeTotal,
      valorTotal: this.pedido.valorTotal,
      desconto:this.pedido.desconto,
      formaPagamento: this.pedido.formaPagamento,
      valorFinal: this.pedido.valorFinal
    }
    
    this.pedidoService.postPedido(pedido).subscribe(data => {
      this.idPedido = data.id;
      this.itens.forEach(element => {

        const item = {
          pedido:{
            id: this.idPedido
          },
          produto:{
            id: element.produto.id,
            valorUnitario: element.produto.valorUnitario
          },
          quantidadeTotal: element.quantidadeTotal,
          valorTotal: element.valorTotal
        }
        
        this.itens = JSON.parse(localStorage.getItem("itens")||"[]");
        this.itemService.postItem(item).subscribe(data =>{console.log(data)})
        const index = this.itens.indexOf(element);
        this.itens.splice(index, 1);
        localStorage.setItem("itens",JSON.stringify(this.itens))
        this.router.navigate(['tax-invoice', this.idPedido])
      });
    })
  })
  }
}
