package dao;

import java.util.List;

import modelo.Curso;

public interface CursosDao {
	Curso findById(int idCurso);
	List<Curso> findAll();
	List<Curso> findByAlumno(String usuario);
	
	
}
