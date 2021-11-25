import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PhonePipe } from './phone-pipe/phone.pipe';



@NgModule({
  declarations: [
    PhonePipe
  ],
  imports: [
    CommonModule
  ]
})
export class SharedModule { }
