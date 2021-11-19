import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Endereco } from '../model/Endereco';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {

  constructor(private http: HttpClient) { }

  private readonly Url='http://localhost:8080/api/endereco';

  postEndereco(endereco: Endereco){
    return this.http.post<Endereco>(this.Url, endereco);
  }

  editEndereco(id: String, endereco: Endereco){
    return this.http.put(this.Url + '/' + id, endereco);
  }

  deleteEndereco(id: String){
    return this.http.delete(this.Url + '/' + id);
  }
}
