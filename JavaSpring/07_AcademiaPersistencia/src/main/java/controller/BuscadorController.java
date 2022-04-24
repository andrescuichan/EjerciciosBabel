package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import modelo.Alumno;
import service.BuscadorServiceInterface;

@CrossOrigin("*")
@Controller
public class BuscadorController {
	
	@Autowired
	BuscadorServiceInterface buscadorService;
	
	
	@PostMapping(value="Alta")
	public String add(@ModelAttribute Alumno alumno, HttpServletRequest request) {
		if(!buscadorService.existeAlumno(alumno.getNombre())){
			buscadorService.altaAlumno(alumno);
			return "inicio";
		}else {
			return "error";
		}
	}
	
	@GetMapping(value="Eliminar")
	public String eliminado(@RequestParam("nombre") String nombre, HttpServletRequest request) {
		buscadorService.eliminarAlumno(nombre);
		return "inicio";
	}
	
	@GetMapping(value="Modificar")
	public String cambiar(@RequestParam("nombre") String nombre, @RequestParam("nota") Double nota ,HttpServletRequest request) {
		buscadorService.modificarNotaAlumno(nombre,nota);
		return "inicio";
	}
	
	@GetMapping(value="Buscador", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> buscar(@RequestParam("curso") String curso, HttpServletResponse response) {
		return buscadorService.alumnosCurso(curso);
	}
	
	@GetMapping(value="BuscadorAllCursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> buscar(HttpServletResponse response) {
		return buscadorService.allCursos();
	}
	
	
}
