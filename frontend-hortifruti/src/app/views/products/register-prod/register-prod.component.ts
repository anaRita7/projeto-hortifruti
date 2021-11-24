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
  selectedImage: File | undefined;
  formDataUploadFile: FormData | undefined;

  constructor(private service: ProdutoService, private router : Router) { }

  ngOnInit(): void {
  }

  onFileChanged(event: Event){
    this.selectedImage = (event.target as HTMLInputElement).files![0];
  }

  postProduct(){

    if (this.selectedImage) {
      this.produto.imagem = this.getNameImagem(this.selectedImage);
      this.formDataUploadFile = new FormData();
      this.formDataUploadFile.append('pid', this.produto.imagem);
      this.formDataUploadFile.append('file', this.selectedImage);
    }

    this.service.postProduto(this.produto, this.formDataUploadFile).subscribe
    (data =>
    {
      if(this.produto.nome == null && this.produto.valorUnitario == null && this.produto.unidadeMedida == null && this.produto.status == null){
        alert("Preencha todos os dados!");
      }
      else if(this.produto.nome == null){
        alert("Preencha todos os dados. Campo de nome está vazio!");
      }
      else if(this.produto.valorUnitario == null){
        alert("Preencha todos os dados. Campo de preço está vazio!");
      }
      else if(this.produto.unidadeMedida == null){
        alert("Preencha todos os dados. Campo de unidade de medida está vazio!");
      }
      else if(this.produto.status == null){
        alert("Preencha todos os dados. Campo de status está vazio!");
      }
      else{
        alert("Produto criado com sucesso!");
        this.router.navigate(['products-consult']);
      }
      
    },
    erro =>
    {
      if(erro.status == 400) {
        alert(erro.error.mensagem);
      }
    }
    );
  }

  getNameImagem(imagem: File) {
    let arrayTermos = imagem.name.split(".");
    let fileName = this.randomStr(10) + "." + arrayTermos[arrayTermos.length - 1];
    return fileName;
  }

  randomStr(tamanho: number) {
    var stringAleatoria = '';
    var caracteres = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    for (var i = 0; i < tamanho; i++) {
        stringAleatoria += caracteres.charAt(Math.floor(Math.random() * caracteres.length));
    }
    return stringAleatoria;
  }

}