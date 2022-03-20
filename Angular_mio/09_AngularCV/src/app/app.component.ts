import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  nombres = "FLAVIO ANDRÉS"; apellidos = "CUICHAN FLORES";
  email = "andrescuichanflores@gmail.com"; telefono = "657486914"; ciudad = "Madrid";
  ocupacion = "ESTUDIANTE DE INGENIERÍA DE TELECOMUNICACIONES";
  universidad = "Universidad Rey Juan Carlos"; 
  carrera ="Grado en Ingenería de Telecomunicaciones especialidad en Sistemas Audiovisuales y Multimedia.";
  programasMainUno = "Python, Ada y Matlab"; programasMainDos = "JavaScript, HTML, CSS y WordPress"
  programasMainTres = "Programación orientada a objetos con Java";
  idiomaIngles = "Inglés TOEIC B2 (Listening and Reading)."; idiomaCoreano = "Coreano Básico (Leer y Escribir).";
  experienciaUno = "Departamento de Comunicación y Marketing" ; experienciaDos = "Profesor Particular";
  voluntariado = "Voluntariado URJC";
}
