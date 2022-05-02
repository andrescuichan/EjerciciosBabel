package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import modelo.Alumno;
import modelo.Curso;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class BuscadorController {
	
	@Autowired
	FormacionService buscadorService;
	
	
	@PostMapping(value="Validar")
	public String validarUsuario(@RequestParam("usuario") String usuario,@RequestParam("password") String password) {
		Alumno alumno = buscadorService.validarUsuario(usuario, password);
		if(alumno != null) {
			return "menu";
		}else {
			return "error";
		}
	}
	
	@GetMapping(value="BuscadorCursosByAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> buscarCursoAlumno(@RequestParam("usuario") String usuario) {
		return buscadorService.cursosAlumno(usuario);
	}
	
	@GetMapping(value="BuscadorAlumnosByCurso", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> buscarAlumnoCurso(@RequestParam("curso") String nombreCurso) {
		return buscadorService.alumnosCurso(nombreCurso);
	}
	
	@GetMapping(value="Cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursos() {
		return buscadorService.listaCursos();
	}
	
	@GetMapping(value="Alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnos() {
		return buscadorService.listalumnos();
	}

	
}
