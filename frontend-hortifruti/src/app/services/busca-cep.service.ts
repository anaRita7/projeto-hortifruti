import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Endereco } from '../model/Endereco';

@Injectable({
  providedIn: 'root'
})
export class BuscaCEPService {

  private urlBase = 'http://viacep.com.br/ws/';

  constructor(private http: HttpClient) { }

  buscarCEP(inputCep: any){
    if(inputCep == null){
      alert("CEP inválido");
    }
      return this.http.get<Endereco>(this.urlBase + inputCep + '/json/');
  }
}
