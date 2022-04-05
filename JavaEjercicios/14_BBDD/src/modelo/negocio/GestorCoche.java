package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.Mysql.DaoCocheMySql;
import modelo.persistencia.interfaces.DaoCoche;

public class GestorCoche {
	
	private DaoCoche daoCoche = new DaoCocheMySql();
	
	
	public boolean matriculasRepetidas(Coche c) {
		boolean repetidos = false;
		for(Coche car: this.listar()) {
			if(car.getMatricula().equals(c.getMatricula())) {
				repetidos = true;
				break;
			}
		}
		return repetidos;
	}
	
	public int alta(Coche c){
		if(c.getMatricula().length() == 7 && !matriculasRepetidas(c) && c.getKilometros() >= 0) {
			boolean alta = daoCoche.alta(c);
			if(alta) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 2;
		}
	}
	
	public boolean baja(int id) {
		boolean baja = daoCoche.baja(id);
		return baja;
	}
	
	public int modificar(Coche c) {
		if(c.getMatricula().length() == 7 && !matriculasRepetidas(c) && c.getKilometros() >= 0) {
			boolean modificar = daoCoche.modificar(c);
			if(modificar) {
				return 0;
			}else {
				return 1;
			}
		}else {
			System.out.println("Solo se acepta matriculas de longitud 7 y no repetidas. Kilometros no negativos");
			return 2;
		}
	}
	
	public Coche buscarId(int id) {
		Coche coche = daoCoche.buscarId(id);
		return coche;
	}
	
	public Coche buscarMatricula(String matricula) {
		Coche coche = daoCoche.buscarMatricula(matricula);
		return coche;
	}
	
	public Coche buscarMarca(String marca) {
		Coche coche = daoCoche.buscarMarca(marca);
		return coche;
	}
	
	public Coche buscarModelo(String modelo) {
		Coche coche = daoCoche.buscarModelo(modelo);
		return coche;
	}
	
	public List<Coche> listar(){
		List<Coche> listaCoches = daoCoche.listar();
		return listaCoches;
	}

}
