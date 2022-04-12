package entidad;

public class JefeFinal implements Personaje{
	
	private String nombre;
	private Arma arma1;
	private Arma arma2;
	private int vida;
	private int vidaFull;

	
	public JefeFinal(String nombre, Arma arma1, Arma arma2) {
		
		this.nombre = nombre;
		this.arma1 = arma1;
		this.arma2 = arma2;
		this.vida = 850;
		this.vidaFull = this.vida;
	}
	
	@Override
	public boolean atacar(Personaje personajeAtacado) {
		System.out.println(this.nombre +("(Jefe Final con ")+ this.arma1 + " y " + this.arma2 + ") ataca a " + personajeAtacado.getNombre());
		int damageTotal = (int) (this.bonificacionDamage() * (arma1.usar() + arma2.usar()));
		System.out.println("damage hecho: " + damageTotal);
		boolean muertePersonajeAtacado = personajeAtacado.recibirDamage(damageTotal);
		if(muertePersonajeAtacado) {
			System.out.println("---- COMBATE TERMINADO ---- \n");
			System.out.println("GANADOR ---> " + this.nombre);		
		}
		return muertePersonajeAtacado;
	}
	
	@Override
	public boolean recibirDamage(int damage) {
		boolean muerto = false;
		System.out.println(this.nombre + " ha recibido damage: " + damage);
		int nuevaVida = this.vida - damage;
		if(nuevaVida >= 0) {
			this.vida = nuevaVida;
			System.out.println(this.nombre + " tiene "+ this.vida + "/" + this.vidaFull+ " de vida\n");
		}else {
			System.out.println(this.nombre + " HA MUERTO!!");
			muerto = true;
		}
		return muerto;
	}
	
	@Override
	public String getNombre() {
		
		return nombre;
	}
	
	public double bonificacionDamage() {
		
		double bonificacion = 1;
		int getRandomValue = (int) (Math.random()*(6-1)) + 1;
		
		if(getRandomValue == 1) {
			bonificacion = 1.1;
		}else if(getRandomValue == 2) {
			bonificacion = 1.2;
		}else if(getRandomValue == 3) {
			bonificacion = 1.3;
		}else if(getRandomValue == 4) {
			bonificacion = 1.4;
		}else {
			bonificacion = 1.5;
		}
		return bonificacion;
	}

	
}
