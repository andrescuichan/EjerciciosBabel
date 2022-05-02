package dao;

import java.util.List;
import modelo.Alumno;


public interface AlumnosDao {
	Alumno findByUsuarioAndPassword(String usuario, String password);
	List<Alumno> findByCurso(String nombreCurso);
	List<Alumno> findAll();
	Alumno findById(String usuario);
	void update(Alumno alumno);
	
}
