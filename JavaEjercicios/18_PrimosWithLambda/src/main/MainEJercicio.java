package main;

import java.util.Scanner;

public class MainEJercicio {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int numeroInput1 = sc.nextInt();
		Runnable numero1 = () -> {
			numeroPrimo(numeroInput1);
			};
		Thread th1 = new Thread(numero1);
		
		int numeroInput2 = sc.nextInt();
		Runnable numero2 = () -> {
			numeroPrimo(numeroInput2);
			};
		Thread th2 = new Thread(numero2);
		
		int numeroInput3 = sc.nextInt();
		Runnable numero3 = () -> {
			numeroPrimo(numeroInput3);
			};
		Thread th3 = new Thread(numero3);
		
		th1.start();
		th2.start();
		th3.start();
		
	}
	
	public synchronized static void numeroPrimo(int numero) {
		
		String numeroPrimo = (numero + " Es primo" );
		if (numero == 0 || numero == 1 || numero == 4) {
			numeroPrimo = (numero + " No es primo" );
		}
		for (int x = 2; x < numero / 2; x++) {
			if (numero % x == 0)
			numeroPrimo = (numero + " No es primo" );
		}
		System.out.println(numeroPrimo);
	}

	
}
