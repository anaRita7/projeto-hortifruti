import { Produto } from '../model/Produto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http:HttpClient) {}
  
  private readonly Url='http://localhost:8080/api/produto';

  getProdutos() {
    return this.http.get<Produto[]>(this.Url);
  }
}
