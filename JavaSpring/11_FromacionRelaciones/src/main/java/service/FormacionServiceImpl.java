package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import dao.CursosDao;
import modelo.Alumno;
import modelo.Curso;

@Service
public class FormacionServiceImpl implements FormacionService{
	
	AlumnosDao alumnosDao;
	CursosDao cursosDao;
	

	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursosDao cursosDao) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
	}
	
	@Override
	public Alumno validarUsuario(String usuario, String password) {
		return alumnosDao.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		return cursosDao.findByAlumno(usuario);
	}

	@Override
	public List<Curso> listaCursos() {
		return cursosDao.findAll();
	}
	
	public List<Alumno> listalumnos(){
		return alumnosDao.findAll();
	}

	@Override
	public List<Alumno> alumnosCurso(String nombreCurso) {
		return alumnosDao.findByCurso(nombreCurso);
	}

	@Override
	public boolean matricularAlumno(String usuario, int idCurso) {
		Curso curso = cursosDao.findById(idCurso);
		Alumno alumno = alumnosDao.findById(usuario);
		if(curso != null && alumno!=null) {
			alumno.getCursos().add(curso);
			alumnosDao.update(alumno);
			return true;
		}
		return false;
	}

	
}
