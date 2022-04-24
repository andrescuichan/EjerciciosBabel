package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import modelo.Alumno;


@Service
public class BuscadorServiceImpl implements BuscadorServiceInterface{

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Transactional
	@Override
	public void altaAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		entityManager.persist(alumno);
	}
	
	@Transactional
	@Override
	public void eliminarAlumno(String nombre) {
		//Otra opcion seria con el metodo this.existeAlumno()
		String jpql="select p from Alumno p where p.nombre= :nombre";
		try {
			Query qr = entityManager.createQuery(jpql);
			qr.setParameter("nombre", nombre);
			Alumno alumno = (Alumno)qr.getSingleResult();
			entityManager.remove(alumno);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("nombre no encontrado o varios alumnos con ese nombre");
		}	
	}
	
	@Transactional
	@Override
	public void modificarNotaAlumno(String nombre, double nuevaNota) {
		String jpql = ("UPDATE Alumno p SET p.nota = :nuevaNota WHERE p.nombre= :nombre");
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nuevaNota", nuevaNota);
		query.setParameter("nombre", nombre);;
		int rowsUpdated = query.executeUpdate();
		if(rowsUpdated== 0) {
			System.out.println("Alumno no encontrado");
		}
	}
	
	@Override
	public List<String> allCursos() {
		String jpql = "SELECT DISTINCT p.curso FROM Alumno p";
		Query qr = entityManager.createQuery(jpql);
		List<String> cursos = (List<String>)qr.getResultList();
		return cursos;
	}
	
	@Override
	public List<Alumno> alumnosCurso(String curso) {
		String jpql="select p from Alumno p where p.curso= :curso";
		Query qr = entityManager.createQuery(jpql);
		qr.setParameter("curso", curso);
		List<Alumno> alumnos = (List<Alumno>)qr.getResultList();
		return alumnos;
	}
	
	@Override
	public Alumno buscarAlumno(int idAlumno) {
		String jpql="select p from Alumno p where p.idAlumno= :idAlumno";
		Alumno alumno = null;
		try {
			Query qr = entityManager.createQuery(jpql);
			qr.setParameter("idAlumno", idAlumno);
			alumno = (Alumno)qr.getSingleResult();
		} catch (Exception e) {
			System.out.println("alumno no encontrado o varios alumnos con ese idAlumno");
		}
		return alumno;
	}
	
	@Override
	public Alumno buscarAlumno(String nombre) {
		String jpql="select p from Alumno p where p.nombre= :nombre";
		Alumno alumno = null;
		try {
			Query qr = entityManager.createQuery(jpql);
			qr.setParameter("nombre", nombre);
			alumno = (Alumno)qr.getSingleResult();
		} catch (Exception e) {
			System.out.println("alumno no encontrado o varios alumnos con ese nombre");
		}
		return alumno;
	}
	
	@Override
	public boolean existeAlumno(String nombre) {
		String jpql="select p from Alumno p where p.nombre= :nombre";
		Query qr = entityManager.createQuery(jpql);
		qr.setParameter("nombre", nombre);
		List<Alumno> alumnos = (List<Alumno>)qr.getResultList();
		return alumnos.size()>0;
	}
	
	
}
