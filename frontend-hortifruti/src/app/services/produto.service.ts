import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { switchMap } from 'rxjs/operators';

import { Produto } from '../model/Produto';


@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http:HttpClient) {}
  
  private readonly urlBase='http://localhost:8080/api/produto';

 
  getProdutos(params: any): Observable<any> {
    console.log("params", params);
    return this.http.get<any>(this.urlBase, { params });
  }

  getProdutosAtivosPage(params: any): Observable<any> {
    console.log("params", params);
    return this.http.get<any>(this.urlBase+'/page', { params });
  }

  getProdutosAtivos() {
    return this.http.get<Produto[]>(this.urlBase+'/ativos');
  }

  getProdutoCodigo(codigo: string){
    return this.http.get<Produto>(this.urlBase + '/codigo/' + codigo);
  }

  getProduto(id: any){
    return this.http.get<Produto>(this.urlBase + '/' + id);
  }

  postProduto(produto: Produto, formDataUploadFile?: FormData){

    let observable = of({});

    if (formDataUploadFile) {
      observable = observable.pipe(
        switchMap(() => {
          return this.http.post('http://localhost:8080/api/imagem', formDataUploadFile, {
            responseType: 'text'
          })
        })
      );
    }

    return observable.pipe(
      switchMap(() => {
        return this.http.post<string>(this.urlBase, produto);
      })
    );
  }

  editProduto(id: any, produto: Produto){
    return this.http.put(this.urlBase + '/' + id, produto);
  }

  editStatusProduto(id: String, status: String){
    return this.http.put(this.urlBase + '/' + id + '/status', status);
  }

  deleteProduto(id: any){
    return this.http.delete(this.urlBase + '/' + id);
  }

}
