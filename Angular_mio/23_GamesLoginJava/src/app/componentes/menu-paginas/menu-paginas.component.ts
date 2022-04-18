import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-paginas',
  templateUrl: './menu-paginas.component.html',
  styleUrls: ['./menu-paginas.component.css']
})
export class MenuPaginasComponent implements OnInit {

  loginDeshabilitado = true;
  gamesDeshabilitado = true;


  constructor(private router:Router) { 

  }

  public BotonMenu(ruta: string){

    if(this.loginDeshabilitado){
      this.router.navigate([ruta])
      this.loginDeshabilitado = false;
    }else if(!this.loginDeshabilitado){
      if(ruta == "/login"){
        this.loginDeshabilitado = true;
      }
      this.router.navigate([ruta])
    }
  }

  ngOnInit(): void {
  }

}
