import { Component, OnInit } from '@angular/core';
import { Endereco } from 'src/app/model/Endereco';
import { BuscaCEPService } from 'src/app/services/busca-cep.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  endereco: Endereco = new Endereco();

  constructor(private serviceBuscaCep: BuscaCEPService) { }

  ngOnInit(): void {
  }

  geraEndereco(inputCep: any){
    this.serviceBuscaCep.buscarCEP(inputCep).subscribe(
      data => this.endereco = data
    )
  }
}
