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
    
  cliente: Cliente = new Cliente();

  constructor(private service: ClienteService, private router : Router) {}

  ngOnInit(): void {
    
  }

  postClient(){
    this.service.postCliente(this.cliente)
    .subscribe(data => {
      alert('Cliente cadastrado com sucesso');
      this.router.navigate(['clients-consult'])
    },
    erro =>
    {
      if(erro.status == 400) {
        alert(erro.error.mensagem);
      }
    }
    );
  }    
}