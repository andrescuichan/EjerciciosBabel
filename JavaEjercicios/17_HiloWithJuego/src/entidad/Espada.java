package entidad;

public class Espada extends Arma {
	
	private int damageBase;
	
	public Espada() {
		
		this.setDamageBase(30);
	}

	@Override
	public int usar() {
		
		System.out.println("(Swaaaaang!) ");
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
		return "Espada";
	}
	
	
}
