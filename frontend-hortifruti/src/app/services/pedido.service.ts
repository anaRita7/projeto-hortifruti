import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PedidoForConsult } from '../model/PedidoForConsult';
import { Pedido } from '../model/Pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  constructor(private http: HttpClient) { }

  private readonly Url='http://localhost:8080/api/pedido';

  getPedidos() {
    return this.http.get<PedidoForConsult[]>(this.Url);
  }

  getPedidoCodigo(codigo: string){
    return this.http.get<PedidoForConsult>(this.Url + '/codigo/' + codigo);
  }

  getPedido(id: string){
    return this.http.get<Pedido>(this.Url + '/' + id);
  }

  postPedido(pedido: Pedido){
    return this.http.post<Pedido>(this.Url, pedido);
  }

  editPedido(id: String, pedido: Pedido){
    return this.http.put(this.Url + '/' + id, pedido);
  }

  deletePedido(id: String){
    return this.http.delete(this.Url + '/' + id);
  }
}
