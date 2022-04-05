package entidad;
import java.util.ArrayList;

public class Directivos extends Empleado{

	private ArrayList<Empleado> listaEmpleadosCargo = new ArrayList<Empleado>();
	
	public Directivos(String nombre, int sueldoBase) {
		super(nombre, sueldoBase);
	}
	
	@Override
	public int sueldoFinal() {
		int numeroEmpleados = this.listaEmpleadosCargo.size();
		int sueldoTotal = super.getSueldoBase() + (numeroEmpleados * 100);
		System.out.println("Directivo = Sueldo Base: " + super.getSueldoBase() + ", Numero Empleados a Cargo: " +
		numeroEmpleados + ", Sueldo Final: " + sueldoTotal);
		return sueldoTotal;
	}
	
	public void addEmpleadoCargo(Empleado empleado) {
		this.listaEmpleadosCargo.add(empleado);
		
	}
	
	
}
