import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/model/Produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  produtosAtivos: Produto[] = [];

  constructor(private service:ProdutoService) {
    this.service.getProdutosAtivos().subscribe(
      data => this.produtosAtivos = data);
   }

  ngOnInit(): void {

  }

}
