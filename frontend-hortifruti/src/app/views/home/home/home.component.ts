import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/model/Item';
import { Produto } from 'src/app/model/Produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  itens: Item[] =[]
  produtosAtivos: Produto[] = [];

  constructor(private service:ProdutoService) {
    this.service.getProdutosAtivos().subscribe(
      data => this.produtosAtivos = data);
   }

  ngOnInit(): void {
  }

  adicionaCarrinho(codProduto: any, qtde: any){
    var itens = JSON.parse(localStorage.getItem("itens")||"[]");
    
    this.service.getProdutoCodigo(codProduto).subscribe(data => {
      const item = {
        idProduto: data.id,
        quantidadeTotal: qtde,
        valorTotal: qtde*data.valorUnitario
      }
      itens.push(item);
      localStorage.setItem("itens",JSON.stringify(itens))
    })
  }

}
