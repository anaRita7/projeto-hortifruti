import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PhonePipe } from './phone-pipe/phone.pipe';
import { CpfCnpjPipe } from './cpf-cnpj-pipe/cpf-cnpj.pipe';



@NgModule({
  declarations: [
    PhonePipe,
    CpfCnpjPipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    PhonePipe,
    CpfCnpjPipe
  ]
})
export class SharedModule { }
