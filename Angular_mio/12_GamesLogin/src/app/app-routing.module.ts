import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactmeComponent } from './componentes/contactme/contactme.component';
import { LoginComponent } from './componentes/login/login.component';
import { AboutmeComponent } from './componentes/aboutme/aboutme.component';
import { ListaVideojuegosComponent } from './componentes/lista-videojuegos/lista-videojuegos.component';

const routes: Routes = [

  {path : '', component : LoginComponent},
  {path : 'lista-videojuegos', component : ListaVideojuegosComponent},
  {path : 'lista-videojuegos/:usuario/:password', component : ListaVideojuegosComponent},
  {path : 'contactme', component : ContactmeComponent},
  {path : 'aboutme', component : AboutmeComponent},
  {path : 'login', component : LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
