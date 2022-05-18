package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import modelo.Hotel;
import service.HotelesService;
@CrossOrigin("*")
@RestController
public class HotelesController {
	
	@Autowired
	HotelesService service;
	
	@ApiOperation(value="Devuelve una lista con todos los hoteles")
	@GetMapping(value="Hoteles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hoteles(){
		return service.allHoteles();
	}
	
	@ApiOperation(value="Devuelve una lista con los datos de los hoteles disponibles")
	@GetMapping(value="HotelesDisponibles", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hotelesDisponibles(){
		return service.allHotelesDisponibles();
	}
	
	@ApiOperation(value="Devuelve los datos del hotel cuyo nombre se recibe en URL")
	@GetMapping(value="Hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotel(@ApiParam(value="Nombre del hotel a buscar") @PathVariable("nombre") String nombre){
		return service.HotelNombre(nombre);
	}
	
	/*
	@PostMapping(value="Alumno",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaAlumno(@RequestBody Alumno alumno) {
		service.altaAlumno(alumno);
	}
	
	@PutMapping(value="Alumno",produces=MediaType.TEXT_PLAIN_VALUE)
	public String actualizar(@RequestParam("idAlumno") int idAlumno, @RequestParam("curso") String curso) {
		return String.valueOf(service.actualizarAlumno(idAlumno, curso));
	}
	
	@DeleteMapping(value="Alumno/{idAlumno}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String eliminar(@PathVariable("idAlumno") int idAlumno) {
		return String.valueOf(service.eliminarAlumno(idAlumno));
	}
	
	
	
	@GetMapping(value="Alumno/{idAlumno}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Alumno buscarAlumno(@PathVariable("idAlumno") int idAlumno){
		return service.buscarAlumno(idAlumno);
	}
	@GetMapping(value="Cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> cursos(){
		r

	*/
}
