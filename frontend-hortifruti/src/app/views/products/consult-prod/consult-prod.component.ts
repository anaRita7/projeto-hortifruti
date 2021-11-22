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
    this.service.editProduto(id, this.produto).subscribe(data => 
    {
      alert('Editado com sucesso');
      this.reloadCurrentRoute();
    });
  }

  irModalExcluir(codigo: any){
    this.service.getProdutoCodigo(codigo).subscribe(data => 
      localStorage.setItem("id", data.id.toString()));
  }

  Excluir(){
    let id = localStorage.getItem("id");
    this.service.deleteProduto(id).subscribe(data => {
      alert("Excluído com sucesso!")
      this.reloadCurrentRoute();
    })
  }

  reloadCurrentRoute() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
  }

}
