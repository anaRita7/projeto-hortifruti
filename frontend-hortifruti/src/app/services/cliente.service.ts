import { Injectable } from '@angular/core';
import { Cliente } from '../model/Cliente';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  private readonly urlBase='http://localhost:8080/api/cliente';

  getClientes(params: any): Observable<any> {
    console.log("params", params);
    return this.http.get<any>(this.urlBase, { params });
  }

  getClientePorDocumento(documento: any){
    return this.http.get<Cliente>(this.urlBase + '/documento/' + documento);
  }

  getCliente(id: any){
    return this.http.get<Cliente>(this.urlBase + '/' + id);
  }

  postCliente(cliente: Cliente){
    return this.http.post<Cliente>(this.urlBase, cliente);
  }

  editCliente(id: any, cliente: Cliente){
    return this.http.put(this.urlBase + '/' + id, cliente);
  }

  deleteCliente(id: any){
    return this.http.delete(this.urlBase + '/' + id);
  }
}
