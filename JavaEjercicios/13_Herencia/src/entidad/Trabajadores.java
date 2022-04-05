package entidad;

public class Trabajadores extends Empleado {

	public Trabajadores(String nombre, int sueldoBase) {
		super(nombre, sueldoBase);
	}
	
	@Override
	public int sueldoFinal() {
		int valorAleatorio = (int)(Math.random()*11);
		int incremento;
		if(valorAleatorio == 5 || valorAleatorio == 6) {
			incremento = 50;
		}else if(valorAleatorio == 7 || valorAleatorio == 8) {
			incremento = 100;
		}else if(valorAleatorio == 9 || valorAleatorio == 10) {
			incremento = 200;
		}else{
			incremento = 0;
		}
		int sueldoTotal = super.getSueldoBase() + incremento;
		System.out.println("Trabajador = Sueldo Base: " + super.getSueldoBase() + ", Valoracion: " +
		valorAleatorio + " -> Incremento: "+ incremento +", Sueldo Final: " + sueldoTotal);
		return sueldoTotal;
	}
	
}
