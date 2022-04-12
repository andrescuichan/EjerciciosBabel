package entidad;

public class Calcular { 
	
	public synchronized void numeroPrimo(int numero) {
		
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
