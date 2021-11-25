import { Component, OnInit} from '@angular/core';
import { Item } from 'src/app/model/Item';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  qtdeItens: number = 0

  constructor() { 
  }

  ngOnInit(): void {
    this.qtdeItens = JSON.parse(localStorage.getItem("itens")||"[]").length
  }
  
}
