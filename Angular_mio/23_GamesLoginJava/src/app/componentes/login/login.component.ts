import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { ClientehttpService } from 'src/app/servicios/clientehttp.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario : string = ""
  password : string = ""
  estadoUsuario : string = "Usuario no encontrado"

  usuarioObligatorioOculto = true
  passwordObligatorioOculto = true
  estadoUsuariooOculto = true


  constructor(private router:Router, private _clientehttp : ClientehttpService) { }

  public routingListaVideojuegos(){
  
    this.router.navigate([ '/lista-videojuegos', this.usuario, this.password])
  }

  public iniciarSesion(){
    
    this.usuarioObligatorioOculto = true
    this.passwordObligatorioOculto = true

    if (this.usuario == ""){
      this.usuarioObligatorioOculto = false
      if(this.password == ""){
        this.passwordObligatorioOculto = false
      }
      this.estadoUsuariooOculto = true
    }else if(this.password == ""){
      this.passwordObligatorioOculto = false
      this.estadoUsuariooOculto = true
    }else{
      
      let obs : Observable<any> = this._clientehttp.validacion(this.usuario, this.password);
      obs.subscribe({
        next:  respuesta => {
          if(respuesta.validado){
            this.routingListaVideojuegos()
          }else{
            this.estadoUsuario = "Usuario no encontrado"
          }
          this.estadoUsuariooOculto = false
        },
        error: e => {
          console.log(`validacionUsuario -> No se han podido ejecutar ${e}`)
          alert(e)
        }
      });
    }
  }

  ngOnInit(): void {
  }

}
