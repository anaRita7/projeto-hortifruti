import { Component, OnInit } from '@angular/core';
import { Endereco } from 'src/app/model/Endereco';
import { Item } from 'src/app/model/Item';
import { Produto } from 'src/app/model/Produto';
import { BuscaCEPService } from 'src/app/services/busca-cep.service';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  endereco: Endereco = new Endereco();
  itens: Item[] = [];

  constructor(private serviceBuscaCep: BuscaCEPService, private serviceProd: ProdutoService) {
  }

  ngOnInit(): void {
    this.itens = JSON.parse(localStorage.getItem("itens")||"[]");
    this.itens.forEach(element => {
      this.serviceProd.getProduto(element.idProduto).subscribe(data => element.produto = data)
      }
    )
  }

  geraEndereco(inputCep: any){
    this.serviceBuscaCep.buscarCEP(inputCep).subscribe(
      data => this.endereco = data
    )
  }

  removeItem(item: Item){
    const element = {
      idProduto: item.idProduto,
      quantidadeTotal: item.quantidadeTotal,
      valorTotal: item.valorTotal 
    }
    var itens = JSON.parse(localStorage.getItem("itens")||"[]");
    const index = itens.indexOf(element);
    this.itens.splice(index, 1);
    localStorage.setItem("itens",JSON.stringify(this.itens))
  }

}
