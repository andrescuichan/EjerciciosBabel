package entidad;

public class Hechizos extends Arma{
	
	private int damageBase;
	
	public Hechizos() {
		this.setDamageBase(50);
		
	}

	@Override
	public int usar() {
		System.out.println("(Abracadabraaaaa!!) ");
		return (this.damageBase);
	}


	public int getDamageBase() {
		return damageBase;
	}


	public void setDamageBase(int damageBase) {
		this.damageBase = damageBase;
	}

	@Override
	public String toString() {
		return "Hechizos";
	}
	
	
}
