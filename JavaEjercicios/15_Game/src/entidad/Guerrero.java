package entidad;

public class Guerrero implements Personaje{

	private String nombre;
	private Atributo atributo;
	private Arma arma;
	private int vida;
	private int vidaFull;
	private int contador = 1;
	
	public Guerrero(String nombre, Arma arma) {
		this.nombre = nombre;
		this.arma = arma;
		this.vida = 300;
		this.vidaFull = this.vida;
		this.atributo = new Fuerza();
	}
	
	@Override
	public boolean atacar(Personaje personajeAtacado) {
		
		int damageHecho = 0;
		int damageTotal = 0;
		int damageAtributo = 0;

		int resto = this.contador  % 3;
		if (resto==0) {
			damageHecho = this.habilidadEspecial();
		}else {
			System.out.println(this.nombre +("(Guerrero con ")+ this.arma + ") ataca a " + personajeAtacado.getNombre());
			damageHecho = arma.usar();
		}
			
		this.contador = this.contador + 1;
		
		if (this.arma instanceof Espada || this.arma instanceof Arco) {
			damageAtributo = this.atributo.danoExtra();
			damageTotal = damageHecho + damageAtributo;
		}else {
			damageHecho = (int) (damageHecho/1.4);
			damageTotal = damageHecho;
		}
		
		System.out.println("Damage Total: " + damageTotal + "(arma/habilidad: " + damageHecho + " + atributo: " + damageAtributo + ")");
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
			System.out.println(this.nombre + " HA MUERTO!!\n");
			muerto = true;
		}
		return muerto;
	}
	
	public int habilidadEspecial() {
		
		System.out.println("CANALIZANDO HABILIDAD ESPECIAL (Convierte la vida actual en damage pero pierde la mitad de vida)");
		System.out.println(this.nombre + " UTILIZO PULSO ESPIRITUAL ");
		int danoTotal = this.vida;
		this.vida = this.vida / 2;
		System.out.println(this.nombre + " redujo su vida a: " + this.vida + "/" + this.vidaFull);
		return danoTotal;
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
		return "Guerrero [nombre=" + nombre + ", atributo=" + atributo + ", arma=" + arma + ", vida=" + vida + "]";
	}

}


