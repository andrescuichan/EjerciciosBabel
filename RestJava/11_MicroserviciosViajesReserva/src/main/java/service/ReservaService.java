package service;

import java.util.List;

import modelo.Reserva;

public interface ReservaService {
	
	List<Reserva> allReservas();
	void altaReserva(Reserva reserva);
	void actualizarPlazasEnVuelo(int idVuelo, int plazasReservadas);
}
