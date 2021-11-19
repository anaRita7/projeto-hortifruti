import { Injectable } from '@angular/core';
import { Cliente } from '../model/Cliente';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  private readonly Url='http://localhost:8080/api/cliente';

  getClientes() {
    return this.http.get<Cliente[]>(this.Url);
  }

  getClientePorDocumento(documento: string){
    return this.http.get<Cliente>(this.Url + '/documento/' + documento);
  }

  getCliente(id: string){
    return this.http.get<Cliente>(this.Url + '/' + id);
  }

  postCliente(cliente: Cliente){
    return this.http.post<Cliente>(this.Url, cliente);
  }

  editCliente(id: String, cliente: Cliente){
    return this.http.put(this.Url + '/' + id, cliente);
  }

  deleteCliente(id: String){
    return this.http.delete(this.Url + '/' + id);
  }
}
