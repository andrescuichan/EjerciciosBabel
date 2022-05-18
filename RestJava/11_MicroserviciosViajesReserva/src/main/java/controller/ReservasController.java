package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import modelo.Reserva;
import service.ReservaService;
@CrossOrigin("*")
@RestController
public class ReservasController {
	
	@Autowired
	ReservaService service;
	
	@GetMapping(value="Reservas", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> reservas(){
		return service.allReservas();
	}
	
	@PostMapping(value="Reserva", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void resgistrarse(@RequestBody ObjectNode json) {
		ObjectMapper mapper = new ObjectMapper();
		Reserva reserva = mapper.convertValue(json.get("reserva"), Reserva.class);
		int plazasReservadas = mapper.convertValue(json.get("plazasReservadas"), int.class);
		System.out.println(reserva);
		System.out.println(plazasReservadas);
		service.altaReserva(reserva);
		service.actualizarPlazasEnVuelo(reserva.getVuelo(), plazasReservadas);
	}
}
