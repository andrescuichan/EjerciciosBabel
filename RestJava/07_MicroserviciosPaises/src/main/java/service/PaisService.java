package service;

import java.util.List;

import modelo.Pais;


public interface PaisService {

	List<String> listaContinentes();
	
	List<Pais> paisesPorContinentes(String continente);
	
	long poblacionContinente(String continente);
	
}
