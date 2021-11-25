import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PedidoForConsult } from '../model/PedidoForConsult';
import { Pedido } from '../model/Pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  constructor(private http: HttpClient) { }

  private readonly urlBase='http://localhost:8080/api/pedido';

  getPedidos() {
    return this.http.get<PedidoForConsult[]>(this.urlBase);
  }

  getPedidoCodigo(codigo: string){
    return this.http.get<Pedido>(this.urlBase + '/codigo/' + codigo);
  }

  getPedido(id: string){
    return this.http.get<Pedido>(this.urlBase + '/' + id);
  }

  postPedido(pedido: Pedido){
    return this.http.post<Pedido>(this.urlBase, pedido);
  }

  editPedido(id: String, pedido: Pedido){
    return this.http.put(this.urlBase + '/' + id, pedido);
  }

  deletePedido(id: String){
    return this.http.delete(this.urlBase + '/' + id);
  }
}
