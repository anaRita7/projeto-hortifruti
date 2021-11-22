import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from 'src/app/services/cliente.service';
import { FormValidations } from 'src/app/shered/form-validations';

import { Cliente } from './../../../model/Cliente';

@Component({
  selector: 'app-register',
  templateUrl: './register-cli.component.html',
  styleUrls: ['./register-cli.component.css']
})
export class RegisterCliComponent implements OnInit {
  cliente: Cliente = new Cliente();
  form!: FormGroup;
  constructor( 
        private service: ClienteService,
        private router : Router,
        private formBuilder : FormBuilder
  ) {}

  ngOnInit(){
    this.form = this.formBuilder.group({
      cpf: this.formBuilder.control({ value: null, disabled: false}, FormValidations.isValidCpf())
    })
 }

  postCliente(){
    this.service.postCliente(this.cliente)
    .subscribe(data => {
      alert('Cliente cadastrado com sucesso');
      this.router.navigate(['clients-consult']);
    });
  }

}