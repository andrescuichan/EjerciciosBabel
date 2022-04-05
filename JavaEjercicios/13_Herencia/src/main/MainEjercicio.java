package main;

import java.util.ArrayList;
import entidad.*;

public class MainEjercicio {

	public static void main(String[] args) {
		
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		Empleado empleado = new Directivos("Andres", 2000);
		listaEmpleados.add(empleado);
		Directivos directivo1 = (Directivos)empleado;
		
		empleado = new Trabajadores("Enrique", 1000);
		listaEmpleados.add(empleado);
		directivo1.addEmpleadoCargo(empleado);
		empleado = new Trabajadores("Isaac", 1200);
		listaEmpleados.add(empleado);
		directivo1.addEmpleadoCargo(empleado);
		empleado = new Trabajadores("Jorge", 1100);
		listaEmpleados.add(empleado);
		directivo1.addEmpleadoCargo(empleado);
		empleado = new Jefes("Ulises", 1500);
		listaEmpleados.add(empleado);
		directivo1.addEmpleadoCargo(empleado);
		
		empleado = new Jefes("Adrian", 1400);
		listaEmpleados.add(empleado);
		
		for (Empleado persona: listaEmpleados) {
			persona.sueldoFinal();
		}
	}	
}
