
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produto } from 'src/app/model/Produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-register',
  templateUrl: './register-prod.component.html',
  styleUrls: ['./register-prod.component.css']
})
export class RegisterProdComponent implements OnInit {

  produto: Produto = new Produto();

  constructor(private service: ProdutoService, private router : Router) { }

  ngOnInit(): void {
  }

  postProduct(){
    this.service.postProduto(this.produto).subscribe
    (data =>
    {
      alert("Produto criado com sucesso!");
      this.router.navigate(['products-consult']);
    },
    erro =>
    {
      if(erro.status == 400) {
        alert(erro.error.mensagem);
      }
    }
    );
  }

}
