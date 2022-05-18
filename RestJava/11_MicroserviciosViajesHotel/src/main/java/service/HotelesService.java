package service;

import java.util.List;

import modelo.Hotel;

public interface HotelesService {

	List<Hotel> allHotelesDisponibles();
	List<Hotel> allHoteles();
	Hotel HotelNombre(String nombre);
	
}
