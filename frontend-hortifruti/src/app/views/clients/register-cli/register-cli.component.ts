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
    
  ngOnInit(): void {
    
  }
  postClient(){
    
  }

}
