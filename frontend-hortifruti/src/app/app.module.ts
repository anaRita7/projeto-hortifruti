import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgxMaskModule } from 'ngx-mask';
import { NgxPaginationModule } from 'ngx-pagination';
import { NgxPrintModule } from 'ngx-print';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProdutoService } from './services/produto.service';
import { SharedModule } from './shared/shared.module';
import { CartComponent } from './views/cart/cart.component';
import { ConsultCliComponent } from './views/clients/consult-cli/consult-cli.component';
import { RegisterCliComponent } from './views/clients/register-cli/register-cli.component';
import { HeaderComponent } from './views/home/header/header.component';
import { HomeComponent } from './views/home/home/home.component';
import { SidebarComponent } from './views/home/sidebar/sidebar.component';
import { OrdersComponent } from './views/orders/orders.component';
import { ConsultProdComponent } from './views/products/consult-prod/consult-prod.component';
import { RegisterProdComponent } from './views/products/register-prod/register-prod.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    SidebarComponent,
    RegisterProdComponent,
    ConsultProdComponent,
    RegisterCliComponent,
    ConsultCliComponent,
    CartComponent,
    OrdersComponent,
    SharedModule
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxMaskModule.forRoot(),
    NgxPrintModule,
    NgxPaginationModule
  ],
  providers: [ProdutoService],
  bootstrap: [AppComponent]
})
export class AppModule{ }
