package entidad;

public class Curanderos implements Personaje{

	private String nombre;
	private Arma arma;
	private int vida;
	private int vidaFull;
	private Atributo atributo;
	private int contador = 1;
	private boolean curacion = false;
	
	public Curanderos(String nombre, Arma arma) {
		
		this.nombre = nombre;
		this.arma = arma;
		this.vida = 200;
		this.vidaFull = this.vida;
		this.atributo = new Sabiduria();
	}
	
	@Override
	public boolean atacar(Personaje personajeAtacado) {
		
		int damageHecho = 0;
		int damageTotal = 0;
		int damageAtributo = 0;
		
		int resto = this.contador  % 2;
		if (resto==0) {
			this.habilidadEspecial();	
		}
		
		System.out.println(this.nombre +("(Curandero con ")+ this.arma + ") ataca a " + personajeAtacado.getNombre());
		damageHecho = arma.usar();	
		this.contador = this.contador + 1;
		
		if (this.arma instanceof Rezos) {
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
		
		System.out.println(this.nombre + " ha recibido damage: " + damage);
		int nuevaVida = this.vida - damage;
		
		if(curacion) {
			curacion = false;
			System.out.println(this.nombre + " Utilizo curacion vida regenerada: " + damage);
			nuevaVida = nuevaVida + damage;
		}
		
		boolean muerto = false;
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
		
		System.out.println("CANALIZANDO HABILIDAD ESPECIAL (Recupera la vida que perdio en un ataque)");
		System.out.println(this.nombre + " UTILIZO CURACION");
		this.curacion = true;
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
		return "Curanderos [nombre=" + nombre + ", arma=" + arma + ", vida=" + vida + ", atributo=" + atributo + "]";
	}
	
	
}

