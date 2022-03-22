import { Component, OnInit } from '@angular/core';
import { Videojuegos } from 'src/app/entidades/videojuegos';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  id: number = 0
  titulo : string = ""
  empresa : string = ""
  media : string = ""
  listaVideojuegos : Videojuegos[] = []

  tituloObligatorioOculto : boolean = true
  empresaObligatorioOculto : boolean = true
  mediaObligatorioOculto : boolean = true
  textoVariable : string = "La puntuación media es obligatorio"

  insertarDeshabilitado : boolean = false;
  modificarDeshabilitado : boolean = true;
  eliminarDeshabilitado : boolean = true;
  vaciarDeshabilitado : boolean = false;

  constructor() { }

  public mensajeSoloNumeros(){
    this.tituloObligatorioOculto = true
    this.empresaObligatorioOculto = true
    this.mediaObligatorioOculto = false
    this.textoVariable = "SOLO ACEPTA NÚMEROSSS"
  }

  public mensajeObligatorioOculto(){
    this.tituloObligatorioOculto = true
    this.empresaObligatorioOculto = true
    this.mediaObligatorioOculto = true
  }

  public insertarVideojuego(){
    if(this.camposObligatorios()){
      if(isNaN(parseInt(this.media))){
        this.mensajeSoloNumeros()
      }else{
        this.mensajeObligatorioOculto()
        let game : Videojuegos = new Videojuegos(this.titulo, this.empresa, parseInt(this.media))
        this.listaVideojuegos.push(game)
      }
    }
  }

  public vaciarFormularios(){
    this.empresa = ""
    this.titulo = ""
    this.media = ""
    this.id = 0
    this.mensajeObligatorioOculto();
    this.insertarDeshabilitado = false;
    this.modificarDeshabilitado = true;
    this.eliminarDeshabilitado = true;
  }

  public seleccionar(games : Videojuegos){
    this.modificarDeshabilitado = false;
    this.eliminarDeshabilitado = false;
    this.insertarDeshabilitado = true;
    this.id = games.id
    this.titulo = games.titulo
    this.empresa = games.empresa
    this.media = String(games.media)
  }

  public camposObligatorios(): boolean{
    let camposRellenos : boolean = false
    if(this.titulo != ""  && this.empresa != "" && this.media != ""){
      camposRellenos = true
    }else{
      this.textoVariable = "La puntuación media es obligatorio"
      this.tituloObligatorioOculto = false
      this.empresaObligatorioOculto = false
      this.mediaObligatorioOculto = false
    }
    return camposRellenos
  }

  public eliminarVideojuego(){    
    for(let a=0; a<this.listaVideojuegos.length; a++){
      if( this.listaVideojuegos[a].id == this.id){
        this.listaVideojuegos.splice(a,1)
        break;
      }
    }
    this.vaciarFormularios()
  }

  public modificarVideojuego(){    
    if(this.camposObligatorios()){
      if(isNaN(parseInt(this.media))){
        this.mensajeSoloNumeros()
      }else{
        for(let a=0; a<this.listaVideojuegos.length; a++){
          let gameAux : Videojuegos = this.listaVideojuegos[a]
          if(gameAux.id == this.id){
            this.listaVideojuegos[a].titulo = this.titulo
            this.listaVideojuegos[a].empresa = this.empresa
            this.listaVideojuegos[a].media = parseInt(this.media)
            break
          }
        }
        this.vaciarFormularios()
      }
    }
  }


  ngOnInit(): void {
  }

}
