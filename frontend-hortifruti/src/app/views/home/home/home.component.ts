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
  itens: Item[] = []
  produtosAtivos: Produto[] = [];
  defaultValue: number = 1;

  constructor(private service:ProdutoService) {
    this.service.getProdutosAtivos().subscribe(
      data => this.produtosAtivos = data);
   }
   
  ngOnInit(): void {
    console.log(this.produtosAtivos);
  }

  adjustQtd(qtd:any){
    console.log('teste')
  }

  adicionaCarrinho(codProduto: any, qtde: any){
    qtde = qtde === undefined ? 1 : qtde;

    let novoProduto = true;
    this.itens = JSON.parse(localStorage.getItem("itens")||"[]");
    this.service.getProdutoCodigo(codProduto).subscribe(data => {
      
      this.itens.forEach(element => {
        if(element.produto.id == data.id){
          element.quantidadeTotal = qtde;
          element.valorTotal = qtde*data.valorUnitario;
          localStorage.setItem("itens",JSON.stringify(this.itens))
          novoProduto = false
          alert("Produto alterado no pedido!");
        }
      });

      if(novoProduto === true){
        var itens = JSON.parse(localStorage.getItem("itens")||"[]");
        const item = {
          imagem: data.imagem,
          quantidadeTotal: qtde,
          valorTotal: qtde*data.valorUnitario,
          produto: {
            id: data.id,
            nome: data.nome,
            unidadeMedida: data.unidadeMedida,
            valorUnitario: data.valorUnitario
          }
        }
        itens.push(item);
        localStorage.setItem("itens",JSON.stringify(itens))
        alert("Produto adicionado ao carrinho!");
      }
    })
  }

}
