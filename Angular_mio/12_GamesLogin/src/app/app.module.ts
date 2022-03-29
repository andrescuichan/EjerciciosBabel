import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './componentes/login/login.component';
import { ListaVideojuegosComponent } from './componentes/lista-videojuegos/lista-videojuegos.component';
import { CabezeraComponent } from './componentes/cabezera/cabezera.component';
import { PiePaginaComponent } from './componentes/pie-pagina/pie-pagina.component';
import { MenuPaginasComponent } from './componentes/menu-paginas/menu-paginas.component';
import { ContactmeComponent } from './componentes/contactme/contactme.component';
import { AboutmeComponent } from './componentes/aboutme/aboutme.component';
import { TitutloHijoComponent } from './componentes/titutlo-hijo/titutlo-hijo.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListaVideojuegosComponent,
    CabezeraComponent,
    PiePaginaComponent,
    MenuPaginasComponent,
    ContactmeComponent,
    AboutmeComponent,
    TitutloHijoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
