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

  page = 1;
  count = 0;
  pageSize = 5;
  pageSizes = [5, 10, 15];


  constructor(private service:ClienteService, private router:Router) {
    this.retrieveCliente();
  }
  ngOnInit(): void {
  }

  getRequestParams(page: number, pageSize: number): any {
    let params: any = {};
    if (page) {
      params[`page`] = page - 1;
    }

    if (pageSize) {
      params[`size`] = pageSize;
    }

    return params;
  }

  retrieveCliente(): void {
    const params = this.getRequestParams(this.page, this.pageSize);
    this.service.getClientes(params)
    .subscribe(
      response => {
        this.clientes = response.content;
        this.count = response.totalElements;
      },
      error => {
        console.log(error);
      });
  }

  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveCliente();
  }

  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveCliente();
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
      alert('Cliente editado com sucesso');
      this.reloadCurrentRoute();
    },
    erro =>
    {
      switch(erro.status) {
        case 400:
          alert(erro.error.mensagem);
          break;
        case 404:
          alert('Cliente não localizado!');
          break;
      }
    })
  }

  irModalExcluir(documento: any){
    this.service.getClientePorDocumento(documento).subscribe(data => 
      localStorage.setItem("id", data.id.toString()));
  }

  Excluir(){
    let id = localStorage.getItem("id");
    this.service.deleteCliente(id).subscribe(data => 
      {
        alert("Cliente excluído com sucesso!")
        this.reloadCurrentRoute();
      },
      erro =>
      {
        if(erro.status == 404) 
          alert('Cliente não localizado!');
      }
    )
  }

  reloadCurrentRoute() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
  }
}
