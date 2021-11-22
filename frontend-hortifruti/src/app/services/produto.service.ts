import { Produto } from '../model/Produto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http:HttpClient) {}
  
  private readonly Url='http://localhost:8080/api/produto';

  getProdutos() {
    return this.http.get<Produto[]>(this.Url);
  }

  getProdutosAtivos() {
    return this.http.get<Produto[]>(this.Url+'/ativos');
  }

  getProdutoCodigo(codigo: string){
    return this.http.get<Produto>(this.Url + '/codigo/' + codigo);
  }

  getProduto(id: any){
    return this.http.get<Produto>(this.Url + '/' + id);
  }

  postProduto(produto: Produto){
    return this.http.post<string>(this.Url, produto);
  }

  editProduto(id: any, produto: Produto){
    return this.http.put(this.Url + '/' + id, produto);
  }

  editStatusProduto(id: String, status: String){
    return this.http.put(this.Url + '/' + id + '/status', status);
  }

  deleteProduto(id: any){
    return this.http.delete(this.Url + '/' + id);
  }

}
