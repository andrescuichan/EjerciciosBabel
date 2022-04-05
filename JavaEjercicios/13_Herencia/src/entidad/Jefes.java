package entidad;

public class Jefes extends Empleado {
	
	public Jefes(String nombre, int sueldoBase) {
		super(nombre, sueldoBase);
	}

	@Override
	public int sueldoFinal() {
		int valorAleatorio = (int)(Math.random()*10+1);
		int incentivo = valorAleatorio * 100;
		int sueldoTotal = super.getSueldoBase() + incentivo;
		System.out.println("Jefe = Sueldo Base: " + super.getSueldoBase() + ", Incentivo: " +
		incentivo + ", Sueldo Final: " + sueldoTotal);
		return sueldoTotal;
	}
}
