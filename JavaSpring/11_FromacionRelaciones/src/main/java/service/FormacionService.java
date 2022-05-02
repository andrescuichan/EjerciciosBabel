package service;

import java.util.List;

import modelo.Alumno;
import modelo.Curso;

public interface FormacionService {

	//Validar usuarios. Dada usuario y contraseña, obtener los datos del alumno
	Alumno validarUsuario(String usuario, String password);
	
	//Cursos de un alumno. A partir del usuario, obtener la lista de cursos en 
	//donde está matriculado en alumno
	List<Curso> cursosAlumno(String usuario);
	
	List<Curso> listaCursos();
	
	List<Alumno> listalumnos();
	
	//Alumnos por curso. A partir de un nombre de curso, se devuelve los alumnos matriculados en dicho curso
	List<Alumno> alumnosCurso(String nombreCurso);
	
	//Matricular alumno. A partir del usuario e idCurso, el alumno se matriula en dicho curso
	boolean matricularAlumno(String usuario, int idCurso);
	
	
}
