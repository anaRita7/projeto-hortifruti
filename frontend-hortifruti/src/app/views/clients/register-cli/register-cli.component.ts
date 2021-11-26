import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from 'src/app/services/cliente.service';

import { Cliente } from './../../../model/Cliente';

@Component({
  selector: 'app-register',
  templateUrl: './register-cli.component.html',
  styleUrls: ['./register-cli.component.css']
})
export class RegisterCliComponent implements OnInit {

  public customPatterns = { 'A': { pattern: new RegExp('\[A-Z\]')} };

  cliente: Cliente = new Cliente();

  constructor(private service: ClienteService, private router : Router) {}

  ngOnInit(): void {
    
  }

  postClient(){
    if(this.cliente.nome == null){
      alert("Preencha todos os dados. Campo de nome está vazio!");
    }
    else{
    this.service.getClientePorDocumento(this.cliente.documento).subscribe(data =>
      {
        alert("Este documento já está cadastrado!")
      },
      erro =>
      {
        if(erro.status == 404) {
          this.service.postCliente(this.cliente)
          .subscribe(data => {
            alert('Cliente cadastrado com sucesso');
            this.router.navigate(['clients-consult'])
          },
          erro =>
          {
            if(erro.status == 400) {
              alert(erro.mensage)
            }
            else if(erro.status == 417) {
              alert('CPF/CNPJ inválido');
            }
          }
          )
        }
      })
    }  
  }  
  }