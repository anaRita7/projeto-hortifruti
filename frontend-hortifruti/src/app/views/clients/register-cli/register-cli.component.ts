import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
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
  form: FormGroup;
  cliente: Cliente = new Cliente();
  constructor(
    private service: ClienteService, 
    private router: Router,
    private formBuilder: FormBuilder
    ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      cpf: this.formBuilder.control({ value: null, disabled: false}, FormValidations.isValidCpf())
    })
  }
  postClient(){
    this.service.postCliente(this.cliente)
    .subscribe(data => {
      alert('Cadastrado com sucesso');
      this.router.navigate(["clients-register"]);
    })
  }

}
