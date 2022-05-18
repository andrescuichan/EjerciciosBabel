package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import modelo.Vuelo;
import service.VuelosService;
@CrossOrigin("*")
@RestController
public class VuelosController {
	
	@Autowired
	VuelosService service;
	
	@GetMapping(value="Vuelos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelos(){
		return service.allVuelos();
	}
	
	@GetMapping(value="VuelosDisponibles/{plazasReservadas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelosDisponibles(@PathVariable("plazasReservadas") int plazasReservadas){
		return service.allVuelosDisponibles(plazasReservadas);
	}
	
	@PutMapping(value="Vuelo")
	public void actualizarPlazas(@RequestParam("idVuelo") int idVuelo, @RequestParam("plazasReservadas") int plazasReservadas) {
		service.actualizarPlazas(idVuelo, plazasReservadas);
	}
	
}
