package entidad;

public interface Personaje {
	
	public boolean atacar(Personaje personajeAtacado);
	
	public boolean recibirDamage(int damage);
	
	public String getNombre();
	
}
