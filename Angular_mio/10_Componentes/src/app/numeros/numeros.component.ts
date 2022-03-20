import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-numeros',
  templateUrl: './numeros.component.html',
  styleUrls: ['./numeros.component.css']
})
export class NumerosComponent implements OnInit {

  numeroInput : number = 0
  numeroInput2 : number = 0
  resultado: number = 0

  constructor() { 
  }

  public calcularOperacion(operador : string){

    if(operador == "+"){
        this.resultado = this.numeroInput + this.numeroInput2
     }else if(operador == "-"){
        this.resultado = this.numeroInput  - this.numeroInput2
    }else if(operador == "*"){
        this.resultado = this.numeroInput  * this.numeroInput2
    }else{
        this.resultado = this.numeroInput  / this.numeroInput2
    }
  }

  ngOnInit(): void {
  }

}
