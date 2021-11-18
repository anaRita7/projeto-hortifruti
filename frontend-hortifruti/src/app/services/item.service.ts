import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item } from '../model/Item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http:HttpClient) { }

  private readonly Url='http://localhost:8080/api/item';

  postItem(item: Item){
    return this.http.post<Item>(this.Url, item);
  }

  editProduto(id: String, item: Item){
    return this.http.put(this.Url + '/' + id, item);
  }

  deleteProduto(id: String){
    return this.http.delete(this.Url + '/' + id);
  }
}
