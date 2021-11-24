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
    this.itens = JSON.parse(localStorage.getItem("itens")||"[]");
  }

  ngOnInit(): void {
  }

  geraEndereco(inputCep: any){
    this.serviceBuscaCep.buscarCEP(inputCep).subscribe(
      data => this.endereco = data
    )
  }

  removeItem(item: Item){
    const element = {
      quantidadeTotal: item.quantidadeTotal,
      valorTotal: item.valorTotal,
      produto: {
        id: item.produto.id,
        nome: item.produto.nome,
        unidadeMedida: item.produto.unidadeMedida,
        valorUnitario: item.produto.valorUnitario
      }
    }
    var itens = JSON.parse(localStorage.getItem("itens")||"[]");
    const index = itens.indexOf(element) - 1;
    this.itens.splice(index, 1);
    localStorage.setItem("itens",JSON.stringify(this.itens))
  }

}
