package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservaDao;
import modelo.Reserva;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	ReservaDao reservasDao;
	RestTemplate template;
	
	String urlBase = "http://servicio-vuelos/viajes";
	
	
	public ReservaServiceImpl(@Autowired ReservaDao reservasDao, @Autowired RestTemplate template) {
		super();
		this.reservasDao = reservasDao;
		this.template = template;
	}

	@Override
	public List<Reserva> allReservas() {
		return reservasDao.findAll();	
	}
	
	@Override
	public void altaReserva(Reserva reserva) {
		reservasDao.save(reserva);	
	}

	@Override
	public void actualizarPlazasEnVuelo(int idVuelo, int plazasReservadas) {
		template.put(urlBase + "/Vuelo?idVuelo="+ idVuelo +"&plazasReservadas=" + plazasReservadas, null);
	}
	
}
