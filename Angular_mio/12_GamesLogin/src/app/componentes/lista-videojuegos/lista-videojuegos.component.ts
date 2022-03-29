import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Games } from 'src/app/entidades/games';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-lista-videojuegos',
  templateUrl: './lista-videojuegos.component.html',
  styleUrls: ['./lista-videojuegos.component.css']
})
export class ListaVideojuegosComponent implements OnInit {

  DetallesGame : string = ""
  listaGames : Games[] = []

  usuario: string = ""
  password: string = ""


  constructor(route:ActivatedRoute) { 
    let gameRegister : Games = new Games("Jak and Daxter", "Naughty Dog", 10, "assets/jak.png")
    this.listaGames.push(gameRegister)
    gameRegister = new Games("League of Legends", "Riot Games", 6, "assets/league.png")
    this.listaGames.push(gameRegister)
    gameRegister = new Games("American Conquest", "Game World", 9, "assets/american.png")
    this.listaGames.push(gameRegister)
    gameRegister = new Games("The Last of Us", "Sony", 8, "assets/the.png")
    this.listaGames.push(gameRegister)

    this.usuario = route.snapshot.params["usuario"]
    this.password = route.snapshot.params["password"]
  }
  
  public clickJuego(titutloJuego: string){
    this.DetallesGame = titutloJuego
  }

  ngOnInit(): void {
  }

}
