package service;

import java.util.List;

import modelo.Alumno;


public interface BuscadorServiceInterface {
	
	public void altaAlumno(Alumno alumno);
	public void eliminarAlumno(String nombre);
	public void modificarNotaAlumno(String nombre, double nuevaNota);
	public List<String> allCursos();
	public List<Alumno> alumnosCurso(String curso);
	public Alumno buscarAlumno(int idAlumno);
	public Alumno buscarAlumno(String nombre);
	
	public boolean existeAlumno(String nombre);

}
