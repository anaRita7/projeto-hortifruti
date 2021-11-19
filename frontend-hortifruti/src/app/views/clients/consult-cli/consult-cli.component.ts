import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/model/Cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-consult',
  templateUrl: './consult-cli.component.html',
  styleUrls: ['./consult-cli.component.css']
})
export class ConsultCliComponent implements OnInit {

  clientes: Cliente[] = [];

  constructor(private service:ClienteService) {
     this.service.getClientes().subscribe(data => this.clientes = data);
  }
  ngOnInit(): void {
  }

}
