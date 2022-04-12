package entidad;

public class Numero implements Runnable{
	
	private int numeroInput;
	private Calcular calcular; 
	
	public Numero(int numero, Calcular calcular) {
		this.numeroInput = numero;
		this.calcular = calcular;
	}
	
	@Override
	public void run() {
		calcular.numeroPrimo(this.numeroInput);
		
	}

}
