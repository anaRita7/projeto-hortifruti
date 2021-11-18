import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { ProdutoService } from 'src/app/services/produto.service';
import { RegisterComponent } from './views/products/register/register.component';
import { ConsultComponent } from './views/products/consult/consult.component';
import { HomeComponent } from './views/home/home/home.component';
import { HeaderComponent } from './views/home/header/header.component';
import { SidebarComponent } from './views/home/sidebar/sidebar.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    ConsultComponent,
    HomeComponent,
    HeaderComponent,
    SidebarComponent
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
