import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { ProdutoService } from 'src/app/services/produto.service';
import { HomeComponent } from './views/home/home/home.component';
import { HeaderComponent } from './views/home/header/header.component';
import { SidebarComponent } from './views/home/sidebar/sidebar.component';
import { RegisterProdComponent } from './views/products/register-prod/register-prod.component';
import { ConsultProdComponent } from './views/products/consult-prod/consult-prod.component';
import { RegisterCliComponent } from './views/clients/register-cli/register-cli.component';
import { ConsultCliComponent } from './views/clients/consult-cli/consult-cli.component';
import { CartComponent } from './views/cart/cart.component';
import { OrdersComponent } from './views/orders/orders.component';
import { TaxInvoiceComponent } from './views/tax-invoice/tax-invoice.component';

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
    TaxInvoiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ProdutoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
