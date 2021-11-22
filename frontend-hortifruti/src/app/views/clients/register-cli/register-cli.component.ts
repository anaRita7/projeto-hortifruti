import { Cliente } from 'src/app/model/Cliente';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ClienteService } from 'src/app/services/cliente.service';
import { FormValidations } from 'src/app/shered/form-validations';

@Component({
  selector: 'app-register',
  templateUrl: './register-cli.component.html',
  styleUrls: ['./register-cli.component.css']
})
export class RegisterCliComponent implements OnInit {
  form: FormGroup | undefined;
  constructor(
    public cliente: Cliente,
    private service: ClienteService, 
    private router: Router,
    private formBuilder: FormBuilder
    ) { }

  ngOnInit(): void {
    
  }

  postCliente(){
    this.service.postCliente(this.cliente)
    .subscribe(data => {
      alert('Cadastrado com sucesso');
      this.router.navigate(["clients-consult"]);
    })
  }

}
