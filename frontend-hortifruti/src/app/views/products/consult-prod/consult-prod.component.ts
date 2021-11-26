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
  selectedImage: File | undefined;
  formDataUploadFile: FormData | undefined;

  page = 1;
  count = 0;
  sort = "status,desc";
  pageSize = 5;
  pageSizes = [5, 10, 15];

  //selectedImage: File | undefined;
  //formDataUploadFile: FormData | undefined;

  constructor(private service:ProdutoService, private router: Router) {
    this.retrieveProduto();
   }

  ngOnInit(): void {
    
  }

  /*onFileChanged(event: Event){
    this.selectedImage = (event.target as HTMLInputElement).files![0];
  }*/

  getRequestParams(page: number, pageSize: number, sort: string): any {
    let params: any = {};
    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    params[`sort`] = sort;

    return params;
  }

  retrieveProduto(): void {
    const params = this.getRequestParams(this.page, this.pageSize, this.sort);
    this.service.getProdutos(params)
    .subscribe(
      response => {
        this.produtos = response.content;
        this.count = response.totalElements;
      },
      error => {
        console.log(error);
      });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveProduto();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveProduto();
  }

  onFileChanged(event: Event){
    this.selectedImage = (event.target as HTMLInputElement).files![0];
  }

  irModalEditar(codigo: any){
    this.service.getProdutoCodigo(codigo).subscribe(data => 
      {
      localStorage.setItem("id", data.id.toString());
      this.service.getProduto(data.id).subscribe(data => this.produto = data);
    });
  }

  Editar(){
    if (this.selectedImage) {
      this.produto.imagem = this.getNameImagem(this.selectedImage);
      this.formDataUploadFile = new FormData();
      this.formDataUploadFile.append('pid', this.produto.imagem);
      this.formDataUploadFile.append('file', this.selectedImage);
    } else {
      this.produto.imagem = "";
    }

    let id = localStorage.getItem("id");
    this.service.editProduto(id, this.produto, this.formDataUploadFile).subscribe(
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
        case 417: 
          alert("Produto não pode ser deletado!"); 
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
