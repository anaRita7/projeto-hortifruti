import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produto } from 'src/app/model/Produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-consult',
  templateUrl: './consult-prod.component.html',
  styleUrls: ['./consult-prod.component.css']
})
export class ConsultProdComponent implements OnInit {

  produtos: Produto[] = [];
  produto: Produto = new Produto();

  page: number = 1;
  itemsPerPage: number = 6;

  constructor(private service:ProdutoService, private router: Router) {
    this.service.getProdutos().subscribe(data => this.produtos = data);
   }

  ngOnInit(): void {
  }

  irModalEditar(codigo: any){
    this.service.getProdutoCodigo(codigo).subscribe(data => 
      {
      localStorage.setItem("id", data.id.toString());
      this.service.getProduto(data.id).subscribe(data => this.produto = data);
    });
  }

  Editar(){
    let id = localStorage.getItem("id");
    this.service.editProduto(id, this.produto).subscribe(
    data => 
    {
      alert('Produto editado com sucesso!');
      this.reloadCurrentRoute();
    },
    erro =>
    {
      switch(erro.status) {
        case 400:
          alert(erro.error.mensagem);
          break;
        case 404:
          alert('Produto não localizado!');
          break;
      }
    })
  }

  irModalExcluir(codigo: any){
    this.service.getProdutoCodigo(codigo).subscribe(data => 
      localStorage.setItem("id", data.id.toString()));
  }

  Excluir(){
    let id = localStorage.getItem("id");
    this.service.deleteProduto(id).subscribe(
    data => 
    {
      alert("Produto excluído com sucesso!")
      this.reloadCurrentRoute();
    },
    erro =>
    { 
      switch(erro.status) { 
        case 500: 
          alert("Produto não pode ser deletado!"); 
          break; 
        case 404: 
          alert('Produto não localizado!'); 
          break; 
      }
    }
  )}

  reloadCurrentRoute() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
  }

}
