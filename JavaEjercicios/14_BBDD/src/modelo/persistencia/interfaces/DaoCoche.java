package modelo.persistencia.interfaces;

import java.util.List;
import modelo.entidad.Coche;

public interface DaoCoche {
	
	boolean alta(Coche c);
	boolean baja(int id);
	boolean modificar(Coche c);
	Coche buscarId(int id);  
	Coche buscarMatricula(String matricula);
	Coche buscarMarca(String marca);
	Coche buscarModelo(String modelo);
	List<Coche> listar();
}
