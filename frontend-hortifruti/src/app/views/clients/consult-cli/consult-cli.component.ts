import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/model/Cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-consult',
  templateUrl: './consult-cli.component.html',
  styleUrls: ['./consult-cli.component.css']
})
export class ConsultCliComponent implements OnInit {

  clientes: Cliente[] = [];
  cliente: Cliente = new Cliente();

  constructor(private service:ClienteService, private router:Router) {
     this.service.getClientes().subscribe(data => this.clientes = data);
  }
  ngOnInit(): void {
  }

  irModalEditar(documento: any){
    this.service.getClientePorDocumento(documento).subscribe(data => 
      {
      localStorage.setItem("id", data.id.toString());
      this.service.getCliente(data.id).subscribe(data => this.cliente = data);
    });
  }

  Editar(){
    let id = localStorage.getItem("id");
    this.service.editCliente(id, this.cliente).subscribe(data => {
      alert('Editado com sucesso');
      this.reloadCurrentRoute();
    });
  }

  irModalExcluir(documento: any){
    this.service.getClientePorDocumento(documento).subscribe(data => 
      localStorage.setItem("id", data.id.toString()));
  }

  Excluir(){
    let id = localStorage.getItem("id");
    this.service.deleteCliente(id).subscribe(data =>{
      alert('Excluído com sucesso');
      this.reloadCurrentRoute()
    });
  }

  reloadCurrentRoute() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
  }
}
