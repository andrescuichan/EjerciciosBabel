package entidad;

public class Rezos extends Arma{
	
	private int damageBase;
	
	public Rezos() {
		
		this.setDamageBase(34);
	}

	@Override
	public int usar() {
		System.out.println("(AVE MARIAAA!)");
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
		return "Rezos";
	}
	
	
}
