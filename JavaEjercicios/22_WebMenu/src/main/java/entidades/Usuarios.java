package entidades;

public class Usuarios {
	
	private String nombre;
	private String password;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", password=" + password + "]";
	}
	
	
}
