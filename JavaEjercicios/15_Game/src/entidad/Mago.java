package entidad;

public class Mago implements Personaje{
	
	private String nombre;
	private Arma arma;
	private int vida;
	private int vidaFull;
	private Atributo atributo;
	private int contador = 1;
	private boolean damageReducido = false;
	
	
	public Mago(String nombre, Arma arma) {
		
		this.nombre = nombre;
		this.arma = arma;
		this.vida = 400;
		this.vidaFull = this.vida;
		this.atributo = new Inteligencia();
	}
	
	@Override
	public boolean atacar(Personaje personajeAtacado) {
		
		int damageHecho = 0;
		int damageTotal = 0;
		int damageAtributo = 0;
		
		int resto = this.contador  % 3;
		if (resto==0) {
			this.habilidadEspecial();	
		}
		
		System.out.println(this.nombre +("(Mago con ")+ this.arma + ") ataca a " + personajeAtacado.getNombre());
		damageHecho = arma.usar();	
		this.contador = this.contador + 1;
		
		if (this.arma instanceof Hechizos) {
			damageAtributo = this.atributo.danoExtra();
			damageTotal = damageHecho + damageAtributo;
		}else {
			damageHecho = (int) (damageHecho/1.4);
			damageTotal = damageHecho;
		}
		
		System.out.println("Damage Total: " + damageTotal + "(arma: " + damageHecho + " + atributo: " + damageAtributo + ")");
		
		boolean muertePersonajeAtacado = personajeAtacado.recibirDamage(damageTotal);
		if(muertePersonajeAtacado) {
			System.out.println("---- COMBATE TERMINADO ---- \n");
			System.out.println("GANADOR ---> " + this.nombre);		
		}
		return muertePersonajeAtacado;
	}
	
	@Override
	public boolean recibirDamage(int damage) {
		
		if(damageReducido) {
			damage = damage / 2;
			damageReducido = false;
			System.out.println(this.nombre + " con Barrera ha recibido la mitad del damage: " + damage);
		}else {
			System.out.println(this.nombre + " ha recibido damage: " + damage);
		}
		
		boolean muerto = false;
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
	
	public void habilidadEspecial() {
		
		System.out.println("CANALIZANDO HABILIDAD ESPECIAL (Reduce a la mitad el damage del enemigo en el proximo ataque)");
		System.out.println(this.nombre + " UTILIZO BARRERA");
		damageReducido = true;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	@Override
	public String toString() {
		return "Mago [nombre=" + nombre + ", arma=" + arma + ", vida=" + vida + ", atributo=" + atributo + "]";
	}
	
	
}
