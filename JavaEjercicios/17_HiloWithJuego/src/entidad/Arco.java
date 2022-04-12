package entidad;

public class Arco extends Arma{
	
	private int damageBase;
	
	public Arco() {
		this.setDamageBase(36);
	}
	
	@Override
	public int usar() {
		System.out.println("(Fiuuuuuuuuuu!!)");
		return this.damageBase;
	}

	public int getDamageBase() {
		return damageBase;
	}

	public void setDamageBase(int damageBase) {
		this.damageBase = damageBase;
	}

	@Override
	public String toString() {
		return "Arco";
	}
	
	
}
