package service;

import java.util.List;
import modelo.Vuelo;

public interface VuelosService {
	
	List<Vuelo> allVuelos();
	List<Vuelo> allVuelosDisponibles(int plazasReservadas);
	boolean actualizarPlazas(int idVuelo, int plazasReservadas);

}
