package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modelo.Pais;
import service.PaisService;

@CrossOrigin("*")
@RestController
public class PaisController {

	@Autowired
	PaisService service;
	
	
	@GetMapping(value="continentes" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes(){
		return service.listaContinentes();
	}
	
	@GetMapping(value="pais/{continente}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisesContinente(@PathVariable("continente") String continente){
		return service.paisesPorContinentes(continente);
	}
	
	@GetMapping(value="poblacion/{continente}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String poblacionPais(@PathVariable("continente") String continente){
		return String.valueOf(service.poblacionContinente(continente));
	}
}
