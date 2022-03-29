import { Component, OnInit, Input } from '@angular/core';
import { UserRegister } from 'src/app/entidades/userRegister';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario : string = ""
  password : string = ""
  listaUserRegister : UserRegister[] = []
  estadoUsuario : string = "Usuario no encontrado"

  usuarioObligatorioOculto = true
  passwordObligatorioOculto = true
  estadoUsuariooOculto = true
  

  constructor(private router:Router) { 
    let userRegister : UserRegister = new UserRegister("Andres", "123")
    this.listaUserRegister.push(userRegister)
    userRegister = new UserRegister("Felix", "1234")
    this.listaUserRegister.push(userRegister)
    userRegister = new UserRegister("Mina", "12345")
    this.listaUserRegister.push(userRegister)
  }

  public routingListaVideojuegos(){
    //Podemos establecer de manera programática a donde queremos ir mediante
    //el objeto router que hemos inyectado previamente
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
      
      this.estadoUsuario = "Usuario no encontrado"
      for(let userRegister of this.listaUserRegister){
        if(userRegister.usuario == this.usuario && userRegister.password == this.password){
          this.routingListaVideojuegos()
          break
        }else if(userRegister.usuario == this.usuario){
          this.estadoUsuario = "Password incorrecto"
        }
      }
      this.estadoUsuariooOculto = false
    }
  }


  ngOnInit(): void {
  }

}
