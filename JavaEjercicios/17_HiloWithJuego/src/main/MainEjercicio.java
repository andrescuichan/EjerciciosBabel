package main;

import java.util.Scanner;

import entidad.Arco;
import entidad.Arma;
import entidad.Curanderos;
import entidad.Espada;
import entidad.Fortaleza;
import entidad.Guerrero;
import entidad.Hechizos;
import entidad.JefeFinal;
import entidad.Mago;
import entidad.Personaje;
import entidad.Rezos;

public class MainEjercicio {

	public static void main(String[] args) {
		
		System.out.println("----- Bienvenidos a Metin2 -----\n");
	
		Arma arma1 = new Espada();
		Arma arma2 = new Arco();
		
		Personaje boss = new JefeFinal("LORD VOLDEMORT", arma1, arma2);
		Fortaleza AbismoHell = new Fortaleza(boss);
		
		Personaje personaje = crearPersonaje("Guerrero","Arco","Andresxp", AbismoHell);
		Runnable hilo = (Runnable)personaje;
		Thread t1 = new Thread(hilo);
		
		personaje = crearPersonaje("Mago","Hechizos","Gandalf", AbismoHell);
		hilo = (Runnable)personaje;
		Thread t2 = new Thread(hilo);
		
		personaje = crearPersonaje("Curandero","Rezos","Sona", AbismoHell);
		hilo = (Runnable)personaje;
		Thread t3 = new Thread(hilo);
		
		personaje = crearPersonaje("Guerrero","Espada","Aragorn", AbismoHell);
		hilo = (Runnable)personaje;
		Thread t4 = new Thread(hilo);
		
		personaje = crearPersonaje("Mago","Rezos","Harry potter", AbismoHell);
		hilo = (Runnable)personaje;
		Thread t5 = new Thread(hilo);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	public static Personaje crearPersonaje(String tipoPersonaje, String tipoArma, String nick, Fortaleza fortaleza) {
		
		Arma arma;
		Personaje personaje;
		
		if(tipoArma.equals("Espada")) {
			arma = new Espada(); 
		}else if(tipoArma.equals("Arco")) {
			arma = new Arco(); 
		}else if(tipoArma.equals("Hechizos")) {
			arma = new Hechizos();
		}else {
			arma = new Rezos();
		}
		
		if(tipoPersonaje.equals("Guerrero")) {
			personaje = new Guerrero(nick, arma, fortaleza);
		}else if(tipoPersonaje.equals("Mago")) {
			personaje = new Mago(nick, arma, fortaleza);
		}else{
			personaje = new Curanderos(nick, arma, fortaleza);
		}
		return personaje;
	}
	
	
}