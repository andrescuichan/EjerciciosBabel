package main;

import java.util.Scanner;

import entidad.Calcular;
import entidad.Numero;

public class MainEjercicio {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Calcular calcular = new Calcular();
		
		int numeroInput = sc.nextInt();
		Numero numero = new Numero(numeroInput,calcular);
		Thread th1 = new Thread(numero);
		
		numeroInput = sc.nextInt();
		numero = new Numero(numeroInput,calcular);
		Thread th2 = new Thread(numero);
		
		numeroInput = sc.nextInt();
		numero = new Numero(numeroInput,calcular);
		Thread th3 = new Thread(numero);
		
		th1.start();
		th2.start();
		th3.start();
		
	}
	

}
