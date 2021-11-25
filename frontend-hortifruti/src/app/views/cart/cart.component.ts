import { Component, OnInit, ViewChild } from '@angular/core';
import { Endereco } from 'src/app/model/Endereco';
import { Item } from 'src/app/model/Item';
import { Pedido } from 'src/app/model/Pedido';
import { Produto } from 'src/app/model/Produto';
import { BuscaCEPService } from 'src/app/services/busca-cep.service';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  percDesconto: any
  soma: any
  endereco: Endereco = new Endereco();
  itens: Item[] = [];
  pedido: Pedido = new Pedido;

  constructor(private serviceBuscaCep: BuscaCEPService, private serviceProd: ProdutoService) {
    this.itens = JSON.parse(localStorage.getItem("itens")||"[]");
  }

  ngOnInit(): void {
    this.soma = 0;
    this.percDesconto = 0
    this.updateTotal();
  }

  aplicarDesconto(desconto:any){
    this.pedido.valorFinal = this.pedido.valorTotal - ((desconto/100)*this.pedido.valorTotal)
    this.pedido.desconto=desconto/100
  }

  updateTotal(){
    this.soma = 0
    this.itens.forEach(element => {
      this.soma += element.valorTotal
    });
    this.pedido.valorTotal = this.soma;
    this.aplicarDesconto(this.percDesconto)
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

}
