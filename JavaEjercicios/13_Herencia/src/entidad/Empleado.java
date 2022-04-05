package entidad;

public abstract class Empleado {
	
	private String nombre;
	private int sueldoBase;
	
	public Empleado(String nombre, int sueldoBase) {
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
	}
	
	public abstract int sueldoFinal();
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSueldoBase() {
		return this.sueldoBase;
	}
	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	@Override
	public String toString() {
		return "Empleado [nombre=" + this.nombre + ", sueldoBase=" + this.sueldoBase + "]";
	}
	

}
